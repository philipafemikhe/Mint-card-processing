package com.card.mintbank.repository;


import com.card.mintbank.entity.Number;
import org.springframework.data.repository.CrudRepository;

public interface CardNumberRepository extends CrudRepository<Number,Integer>{
}
