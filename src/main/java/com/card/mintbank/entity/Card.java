package com.card.mintbank.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    private Number number;
    private String referenceNo;
    private String type;
    private String scheme;
    private String brand;
    private String prepaid;
    private int hints;

    @OneToOne
    private Country country;

    @OneToOne
    private Bank bank;

}
