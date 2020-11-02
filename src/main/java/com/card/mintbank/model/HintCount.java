package com.card.mintbank.model;

import lombok.*;

import java.util.List;
import java.util.Map;

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
    private Map payload;
}