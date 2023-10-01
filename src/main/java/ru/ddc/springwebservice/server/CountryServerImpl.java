package ru.ddc.springwebservice.server;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import ru.ddc.springwebservice.models.CountryEntity;
import ru.ddc.springwebservice.repository.CountryRepo;

import java.util.Optional;
@WebService
public class CountryServerImpl implements CountryServer{

    private CountryRepo countryRepo;

    public CountryServerImpl(CountryRepo countryRepo) {
        this.countryRepo = countryRepo;
    }

    @WebMethod
    @Override
    public Optional<CountryEntity> findByName(String name) {
        CountryEntity country = countryRepo
                                    .findAll()
                                    .stream()
                .filter(c -> c.getName().equals(name))
                .findAny()
                .orElse(null);
        return Optional.ofNullable(country);
    }
}
