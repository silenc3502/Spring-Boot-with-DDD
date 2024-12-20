package com.example.demo.card.service.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CreateCardRequest {
    private final int cardNumber;
}
