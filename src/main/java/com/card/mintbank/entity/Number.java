package com.card.mintbank.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "numbers")
public class Number {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int length;
    private boolean luhn;
}