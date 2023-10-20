package ru.ddc.springwebservice.models;

public enum CurrencyEnum {
    GBP,
    EUR,
    PLN,
    RUB;

    public String value() {
        return name();
    }
}
