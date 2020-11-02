package com.card.mintbank.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="countries")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String numeric;
    private String alpha2;
    private String name;
    private String emoji;
    private String currency;
    private int latitude;
    private int longitude;

    public Country() {
    }

    public Country(String numeric, String alpha2, String name, String emoji, String currency, int latitude, int longitude) {
        this.numeric = numeric;
        this.alpha2 = alpha2;
        this.name = name;
        this.emoji = emoji;
        this.currency = currency;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumericNo() {
        return numeric;
    }

    public void setNumericNo(String numericNo) {
        this.numeric = numericNo;
    }

    public String getAlpha2() {
        return alpha2;
    }

    public void setAlpha2(String alpha2) {
        this.alpha2 = alpha2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmoji() {
        return emoji;
    }

    public void setEmoji(String emoji) {
        this.emoji = emoji;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", numeric=," + numeric + '\'' +
                ", alpha2='" + alpha2 + '\'' +
                ", name='" + name + '\'' +
                ", emoji='" + emoji + '\'' +
                ", currency='" + currency + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}