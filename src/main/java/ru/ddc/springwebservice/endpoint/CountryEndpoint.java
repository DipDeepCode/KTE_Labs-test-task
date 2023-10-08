package ru.ddc.springwebservice.endpoint;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ru.ddc.springwebservice.dto.*;
import ru.ddc.springwebservice.models.CountryEntity;
import ru.ddc.springwebservice.models.CurrencyEnum;
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

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryByIdRequest")
    @ResponsePayload
    public GetCountryResponse getCountryById(@RequestPayload GetCountryByIdRequest request) {
        GetCountryResponse response = new GetCountryResponse();
        CountryEntity countryEntity = countryService.findById(request.getId());
        response.setCountry(convertToCountry(countryEntity));

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addCountryRequest")
    @ResponsePayload
    public AddCountryResponse getName(@RequestPayload AddCountryRequest request) {
        AddCountryResponse response = new AddCountryResponse();
        Country country = request.getCountry();
        CountryEntity countryEntity = countryService.save(convertToCountryEntity(country));
        Country saveCountry = convertToCountry(countryEntity);
        response.setName(saveCountry.getName());

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteCountryRequest")
    @ResponsePayload
    public DeleteCountryResponse deleteCountry(@RequestPayload DeleteCountryRequest request) {
        DeleteCountryResponse response = new DeleteCountryResponse();
        String str = countryService.deleteById(request.getId());
        response.setDeleteCountry(str);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteCountryRequestByName")
    @ResponsePayload
    public DeleteCountryResponse deleteCountryByName(@RequestPayload DeleteCountryRequestByName request) {
        DeleteCountryResponse response = new DeleteCountryResponse();
        String str = countryService.deleteByName(request.getName());
        response.setDeleteCountry(str);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateCountryRequest")
    @ResponsePayload
    public UpdateCountryResponse updateCountryResponse(@RequestPayload UpdateCountryRequest request) {
        UpdateCountryResponse response = new UpdateCountryResponse();
        CountryEntity countryEntity = countryService.update(convertToCountryEntity(request.getCountry()));

        if(countryEntity.equals(request.getCountry())) {
            countryEntity.setPopulation(request.getCountry().getPopulation());
            countryEntity.setName(request.getCountry().getName());
            countryEntity.setCapital(request.getCountry().getCapital());
            countryEntity.setCurrency(convertToCurrencyEnum(request.getCountry().getCurrency()));
        }
        Country country = convertToCountry(countryEntity);
        response.setCountry(country);
        return response;
    }

    private Country convertToCountry(CountryEntity countryEntity) {

        return mapper.map(countryEntity, Country.class);
    }

    private CountryEntity convertToCountryEntity(Country country) {
        return mapper.map(country, CountryEntity.class);
    }

    private CurrencyEnum convertToCurrencyEnum(Currency currency) {
        return  mapper.map(currency, CurrencyEnum.class);
    }





}
