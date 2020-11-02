package com.card.mintbank.model;

import lombok.*;

import java.util.Map;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class HintPayload {
    private Map<String, Integer> cardNo;
}
