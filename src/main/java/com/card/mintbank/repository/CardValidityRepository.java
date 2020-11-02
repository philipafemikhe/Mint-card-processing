package com.card.mintbank.repository;


import com.card.mintbank.entity.CardValidity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardValidityRepository extends JpaRepository<CardValidity, Integer> {
}
