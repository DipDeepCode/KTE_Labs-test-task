package ru.ddc.springwebservice.models;


import jakarta.persistence.*;

@Entity
@Table(name = "country")
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
    private CurrencyEnum currency;

    public CountryEntity() {
    }

    public CountryEntity(long id, String name, int population, String capital, CurrencyEnum currency) {
        this.id = id;
        this.name = name;
        this.population = population;
        this.capital = capital;
        this.currency = currency;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public CurrencyEnum getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyEnum currency) {
        this.currency = currency;
    }


    @Override
    public String toString() {
        return "CountryEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", population=" + population +
                ", capital='" + capital + '\'' +
                ", currency=" + currency +
                '}';
    }
}
