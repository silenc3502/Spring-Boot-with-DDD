package com.example.demo.card.controller.request_form;

import com.example.demo.card.service.request.CreateCardRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CreateCardRequestForm {
    private final int cardNumber;

    public CreateCardRequest toCreateCardRequest() {
        return new CreateCardRequest(this.cardNumber);
    }
}
