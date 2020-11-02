package com.card.mintbank.entity;

import javax.persistence.*;

@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    private Number number;
    private String type;
    private String scheme;
    private String brand;
    private String prepaid;

    @OneToOne
    private Country country;

    @OneToOne
    private Bank bank;


    public Card() {
    }

    public Card(Number number, String type, String scheme, String brand, String prepaid, Country country, Bank bank) {
        this.number = number;
        this.type = type;
        this.scheme = scheme;
        this.brand = brand;
        this.prepaid = prepaid;
        this.country = country;
        this.bank = bank;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Number getNumber() {
        return number;
    }

    public void setNumber(Number number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPrepaid() {
        return prepaid;
    }

    public void setPrepaid(String prepaid) {
        this.prepaid = prepaid;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", number=" + number +
                ", type='" + type + '\'' +
                ", scheme='" + scheme + '\'' +
                ", brand='" + brand + '\'' +
                ", prepaid='" + prepaid + '\'' +
                ", country=" + country +
                ", bank=" + bank +
                '}';
    }
}
