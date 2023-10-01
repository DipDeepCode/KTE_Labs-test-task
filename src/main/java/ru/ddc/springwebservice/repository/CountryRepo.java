package ru.ddc.springwebservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ddc.springwebservice.models.CountryEntity;

public interface CountryRepo extends JpaRepository<CountryEntity, Long> {

}
