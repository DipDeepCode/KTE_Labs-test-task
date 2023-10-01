package ru.ddc.springwebservice.models;

public enum CurrencyEntity {
    GBR,
    EUR,
    PLN;

    public String value() {
        return name();
    }
}
