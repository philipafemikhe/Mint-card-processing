package com.card.mintbank.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class HintCount {
    private boolean success;
    private int start;
    private int limit;
    private int size;
    private List<HintPayload> payload;
}