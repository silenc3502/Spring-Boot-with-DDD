package com.example.demo.card.service;


import com.example.demo.card.service.request.CreateCardRequest;
import com.example.demo.card.service.response.CreateCardResponse;

public interface CardService {
    CreateCardResponse createCard(CreateCardRequest createCardRequest);
}
