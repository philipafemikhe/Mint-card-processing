package com.card.mintbank.controller;

import com.card.mintbank.entity.Card;
import com.card.mintbank.entity.CardValidity;
import com.card.mintbank.model.HintCount;
import com.card.mintbank.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/card-scheme")
public class CardController {
    @Autowired
    private CardService cardService;

    @RequestMapping("/get/{id}")
    public Card getCard(@PathVariable String id){
        Card card = this.cardService.getCard(id);
        return card;
    }

    @RequestMapping("/verify/{id}")
    public CardValidity verifyCard(@PathVariable int id){
        return cardService.verifyCard(String.valueOf(id));
    }

    @RequestMapping("/stats")
    public HintCount cardStatistics(@RequestParam(value = "start") int start, @RequestParam(value = "limit") int limit){
        System.out.println("Generating statistics with start " + start + " and limit " + limit);
        return cardService.cardStatistics(start, limit);
    }

}
