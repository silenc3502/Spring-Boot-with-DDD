package com.example.demo.card.service.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CreateCardResponse {

    private final int cardId;
    private final String cardName;
    private final String cardPlacement;
    private final String cardStatusEffect;
    private final String graphicTextureName;
    private final int damage;
    private final int hp;

    public static CreateCardResponse from(
            int cardId,
            String cardName,
            String cardPlacement,
            String cardStatusEffect,
            String graphicTextureName,
            int damage,
            int hp
    ) {
        return new CreateCardResponse(
                cardId,
                cardName,
                cardPlacement,
                cardStatusEffect,
                graphicTextureName,
                damage,
                hp
        );
    }
}
