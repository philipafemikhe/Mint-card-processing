package com.card.mintbank.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name="countries")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "numeric_code")
    private String numeric;

    private String alpha2;
    private String name;
    private String emoji;
    private String currency;
    private int latitude;
    private int longitude;
}