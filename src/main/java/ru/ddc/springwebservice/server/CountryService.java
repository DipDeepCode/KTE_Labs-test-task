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

    public CountryEntity findById(long id) {
        return countryRepository.findById(id).orElseThrow();
    }

    public CountryEntity save(CountryEntity countryEntity){
        return countryRepository.save(countryEntity);
    }

    public String deleteById(long id) {
        try {
            countryRepository.deleteById(id);
            return "Delete successful";
        } catch (Exception e) {
            return "Delete not successful";
        }
    }

    public String deleteByName(String name) {
        try {
            countryRepository.deleteByName(name);
            return "Delete successful";
        } catch(Exception e) {
            return "Delete not successful";
        }
    }

    public CountryEntity update(CountryEntity countryEntity) {
       return countryRepository.save(countryEntity);

    }


}


