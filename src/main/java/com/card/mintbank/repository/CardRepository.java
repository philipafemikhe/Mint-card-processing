package com.card.mintbank.repository;

import com.card.mintbank.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Integer> {
    public Card findByReferenceNo(String id);
}
