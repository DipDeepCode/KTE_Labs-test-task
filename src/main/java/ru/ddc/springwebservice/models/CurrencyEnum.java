package ru.ddc.springwebservice.models;

public enum CurrencyEnum {
    GBR,
    EUR,
    PLN;

    public String value() {
        return name();
    }
}
