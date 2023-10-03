package ru.ddc.springwebservice.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ddc.springwebservice.models.CountryEntity;
import ru.ddc.springwebservice.repository.CountryRepository;

@Service
public class CountryService {
    private final CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public CountryEntity findByName(String name){
        return countryRepository.findByName(name).orElseThrow();
    }

}


