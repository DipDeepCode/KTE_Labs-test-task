package ru.ddc.springwebservice.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ru.ddc.springwebservice.dto.GetCountryRequest;
import ru.ddc.springwebservice.dto.GetCountryResponse;
import ru.ddc.springwebservice.models.CountryEntity;
import ru.ddc.springwebservice.server.СountryService;

import java.util.Optional;

@Endpoint
public class CountryEndpoint {
    private static final String NAMESPACE_URI = "http://ddc.ru/springwebservice/dto";

    private final СountryService countryService;

    @Autowired
    public CountryEndpoint(СountryService countryService) {
        this.countryService = countryService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
        GetCountryResponse response = new GetCountryResponse();
        Optional<CountryEntity> countryEntity = countryService.findByName(request.getName());
        response.setCountry(countryEntity.get().getCountry());

        return response;
    }
}
