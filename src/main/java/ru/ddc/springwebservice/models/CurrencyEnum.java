package ru.ddc.springwebservice.models;

public enum CurrencyEnum {
    GBP,
    EUR,
    PLN;

    public String value() {
        return name();
    }
}
