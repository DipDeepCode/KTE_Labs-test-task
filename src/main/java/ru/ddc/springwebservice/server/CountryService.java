package ru.ddc.springwebservice.server;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ddc.springwebservice.models.CountryEntity;
import ru.ddc.springwebservice.repository.CountryRepository;

import java.util.List;

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

    public CountryEntity findById(long id) {
        return countryRepository.findById(id).orElseThrow();
    }

    @Transactional
    public CountryEntity save(CountryEntity countryEntity){
        return countryRepository.save(countryEntity);
    }
    @Transactional
    public void deleteById(long id) {
        countryRepository.deleteById(id);
    }

    @Transactional
    public void deleteByName(String name) {
        countryRepository.deleteByName(name);
    }

    @Transactional
    public CountryEntity update(CountryEntity countryEntity) {
       return countryRepository.save(countryEntity);

    }


}


