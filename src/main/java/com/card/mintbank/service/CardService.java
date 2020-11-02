package com.card.mintbank.service;

import com.card.mintbank.entity.Card;
import com.card.mintbank.entity.CardValidity;
import com.card.mintbank.repository.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

@Service
public class CardService {

    @Autowired
    private BankRepository bankRepository;

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private CardValidityRepository cardValidityRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private CardNumberRepository cardNumberRepository;

    public Card getCard(){
        try {
            ObjectMapper mapper = new ObjectMapper();
            Card card = mapper.readValue(new URL("https://lookup.binlist.net/45717360"),Card.class);
            System.out.println(card.toString());
            this.cardRepository.save(card);
            this.cardNumberRepository.save(card.getNumber());
            this.bankRepository.save(card.getBank());
            this.countryRepository.save(card.getCountry());
            System.out.println("Card detail: " + card.toString());
            return card;
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public CardValidity verifyCard(int id){
        CardValidity data = null;
        Card card = this.cardRepository.findById(id).get();
        if(card != null){
            data = new CardValidity();
            data.setCard(card);
            data.setValid(true);
            return data;
        }
        data.setCard(null);
        data.setValid(false);
        return data;
    }

    public String cardStatistics(int start, int limit ){
        return "Card Statistics: start " + start + ", limit " + limit;
    }

}
