package com.card.mintbank.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class KafkaPayload {
    private String scheme;
    private String type;
    private String bank;
}
