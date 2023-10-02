package ru.ddc.springwebservice.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ddc.springwebservice.models.CountryEntity;
import ru.ddc.springwebservice.repository.CountryRepository;

import java.util.Optional;

@Service
public class СountryService {

    private CountryRepository countryRepository;

    @Autowired
    public СountryService(CountryRepository countryRepository) {

        this.countryRepository = countryRepository;
    }

    public Optional<CountryEntity> findByName(String name){
        return countryRepository.findByName(name);
    }

}
