package ru.ddc.springwebservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ddc.springwebservice.models.CountryEntity;

import java.util.Optional;

public interface CountryRepository extends JpaRepository<CountryEntity, Long> {
    Optional<CountryEntity> findByName(String name);
    Optional<CountryEntity> deleteByName(String name);



}
