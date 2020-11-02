package com.card.mintbank.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name="card_validity")
public class CardValidity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private boolean valid;


    @OneToOne
    @JoinColumn(insertable = false, updatable = false, name = "card_id")
    private Card card;
}
