package ru.ddc.springwebservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.ddc.springwebservice.models.CountryEntity;

import java.util.List;
import java.util.Optional;

public interface CountryRepository extends JpaRepository<CountryEntity, Long> {
    Optional<CountryEntity> findByName(String name);
    @Override
    void deleteById(Long aLong);

    void deleteByName(String name);



}
