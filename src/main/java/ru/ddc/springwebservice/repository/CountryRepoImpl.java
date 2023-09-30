package ru.ddc.springwebservice.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.ddc.springwebservice.models.Country;

import java.util.List;
import java.util.Optional;

@Component
public class CountryRepoImpl implements CountryRepo{

    private final String SQL_SELECT_ALL = "SELECT * FROM country";
    private final String SQL_SELECT_BY_ID ="SELECT * FROM country WHERE id = ?";
    private final String SQL_SELECT_BY_NAME = "SELECT * FROM country WHERE name = ?";

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CountryRepoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<Country> getCountryById(long id) {
        return Optional.ofNullable(jdbcTemplate.query(SQL_SELECT_BY_ID, new Object[]{}, new BeanPropertyRowMapper<>(Country.class))
                .stream().findAny().orElse(null));
    }

    @Override
    public List<Country> findAll() {
        return jdbcTemplate.query(SQL_SELECT_ALL, new BeanPropertyRowMapper<>(Country.class));
    }

    @Override
    public Optional<Country> getCountryByName(String name) {
        return Optional.ofNullable(jdbcTemplate.query(SQL_SELECT_BY_NAME, new Object[]{}, new BeanPropertyRowMapper<>(Country.class))
                .stream().findAny().orElse(null));
    }
}
