package ru.ddc.springwebservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ddc.springwebservice.models.CountryEntity;

import java.util.Optional;

public interface CountryRepo extends JpaRepository<CountryEntity, Long> {
    Optional<CountryEntity> findByName(String name);

}
