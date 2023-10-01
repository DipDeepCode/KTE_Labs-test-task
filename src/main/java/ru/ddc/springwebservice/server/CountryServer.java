package ru.ddc.springwebservice.server;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import ru.ddc.springwebservice.models.CountryEntity;

import java.util.Optional;

@WebService
public interface CountryServer {

    @WebMethod
    public Optional<CountryEntity> findByName(String name);


}
