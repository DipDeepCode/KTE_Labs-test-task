package ru.ddc.springwebservice.endpoint;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ru.ddc.springwebservice.dto.Country;
import ru.ddc.springwebservice.dto.GetCountryRequest;
import ru.ddc.springwebservice.dto.GetCountryResponse;
import ru.ddc.springwebservice.models.CountryEntity;
import ru.ddc.springwebservice.server.CountryService;


@Endpoint
public class CountryEndpoint {
    private static final String NAMESPACE_URI = "http://ddc.ru/springwebservice/dto";

    private final CountryService countryService;
    private final ModelMapper mapper;

    @Autowired
    public CountryEndpoint(CountryService countryService, ModelMapper mapper) {
        this.countryService = countryService;
        this.mapper = mapper;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
        GetCountryResponse response = new GetCountryResponse();
        CountryEntity countryEntity = countryService.findByName(request.getName());
        Country country = convertToCountry(countryEntity);
        response.setCountry(country);

        return response;
    }

    private Country convertToCountry(CountryEntity countryEntity) {
        return mapper.map(countryEntity, Country.class);
    }

}
