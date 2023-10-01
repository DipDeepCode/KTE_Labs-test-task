package ru.ddc.springwebservice.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.ddc.springwebservice.dto.Currency;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="country")
public class CountryEntity {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name= "name")
    private String name;

    @Column(name="population")
    private int population;

    @Column(name="capital")
    private String capital;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "currency", length = 3)
    private Currency currency;
}
