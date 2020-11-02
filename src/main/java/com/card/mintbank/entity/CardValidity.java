package com.card.mintbank.entity;

import javax.persistence.*;

@Entity(name="card_validity")
public class CardValidity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private boolean valid;

    @OneToOne
    @JoinColumn(insertable = false, updatable = false, name = "card_id")
    private Card card;

    public CardValidity() {
    }

    public CardValidity(boolean valid, Card card) {
        this.valid = valid;
        this.card = card;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "CardValidity{" +
                "valid=" + valid +
                ", card=" + card +
                '}';
    }
}
