package com.card.mintbank.service;

import com.card.mintbank.entity.Card;
import com.card.mintbank.entity.CardValidity;
import com.card.mintbank.entity.Country;
import com.card.mintbank.model.HintCount;
import com.card.mintbank.model.HintPayload;
import com.card.mintbank.repository.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private NumberRepository numberRepository;

    public Card getCard(String ref){
        try {
            ObjectMapper mapper = new ObjectMapper();
            Card card = mapper.readValue(new URL("https://lookup.binlist.net/" + ref),Card.class);
            System.out.println(card.toString());
            this.numberRepository.save(card.getNumber());
            this.bankRepository.save(card.getBank());
            Country country = processCountry(card);
            this.countryRepository.save(country);
            card.setCountry(country);
            card.setReferenceNo(ref);
            this.cardRepository.save(card);

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

    private Country processCountry(Card card){
        Country country = new Country();
        country.setAlpha2(card.getCountry().getAlpha2());
        country.setCurrency(card.getCountry().getCurrency());
        country.setEmoji(card.getCountry().getEmoji());
        country.setLatitude(card.getCountry().getLatitude());
        country.setLongitude(card.getCountry().getLongitude());
        country.setName(card.getCountry().getName());
        country.setNumeric(card.getCountry().getNumeric());
        return country;
    }

    public CardValidity verifyCard(String id){
        CardValidity data = null;
        Card card = this.cardRepository.findByReferenceNo(id);
        if(card != null){
            data = new CardValidity();
            data.setCard(card);
            data.setValid(true);
            card.setHints(card.getHints() + 1);
            return data;
        }
        data.setCard(null);
        data.setValid(false);
        return data;
    }

    public HintCount cardStatistics(int start, int limit ){
        HintCount hintCount = new HintCount();
        hintCount.setLimit(limit);
        hintCount.setStart(start);
        hintCount.setSize(133); // may vary
        List<Card> cards = this.cardRepository.findAll();

        HintPayload hintPayload = new HintPayload();
        Map cardMap = new HashMap<>();
        for(int i=0; i <= 3; i++){
            if(cards.size() < i +1) break;
            Card thisCard = cards.get(i);
            cardMap.put(thisCard.getReferenceNo(),thisCard.getHints());
//            hintPayload. .setCardNo(cards.get(i).getReferenceNo().toString(), 3);
        }
        hintCount.setPayload((List<HintPayload>) cardMap);
        return hintCount; // "Card Statistics: start " + start + ", limit " + limit;
    }

}
