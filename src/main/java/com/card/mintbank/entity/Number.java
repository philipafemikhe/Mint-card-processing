package com.card.mintbank.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Number {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int length;
    private boolean luhn;

    public Number() {
    }

    public Number(int length, boolean luhn) {
        this.length = length;
        this.luhn = luhn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean isLuhn() {
        return luhn;
    }

    public void setLuhn(boolean luhn) {
        this.luhn = luhn;
    }

    @Override
    public String toString() {
        return "Number{" +
                "id=" + id +
                ", lenght=" + length +
                ", luhn=" + luhn +
                '}';
    }
}