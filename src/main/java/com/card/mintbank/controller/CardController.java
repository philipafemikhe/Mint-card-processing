package com.card.mintbank.controller;

import com.card.mintbank.entity.Card;
import com.card.mintbank.entity.CardValidity;
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

    @RequestMapping("/get")
    public Card getCard(){
        Card card = this.cardService.getCard();
        return card;
    }

    @RequestMapping("/verify/{id}")
    public CardValidity verifyCard(@PathVariable int id){
        return cardService.verifyCard(id);
    }

    @RequestMapping("/stats?start=1&limit=3")
    public String cardStatistics(@RequestParam int start, int limit){
        return cardService.cardStatistics(start, limit);
    }

}
