package ru.ddc.springwebservice.repository;

import ru.ddc.springwebservice.models.Country;

import java.util.List;
import java.util.Optional;

public interface CountryRepo {

    Optional<Country> getCountryById(long id);
    List<Country> findAll();
    Optional<Country> getCountryByName(String name);


}
