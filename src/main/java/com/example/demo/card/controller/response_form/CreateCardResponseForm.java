package com.example.demo.card.controller.response_form;

import com.example.demo.card.service.response.CreateCardResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CreateCardResponseForm {
    private final int cardId;
    private final String cardName;
    private final String cardPlacement;
    private final String cardStatusEffect;
    private final String graphicTextureName;
    private final int damage;
    private final int hp;

    // Factory method to map service response to response form
    public static CreateCardResponseForm from(CreateCardResponse createCardResponse) {
        return new CreateCardResponseForm(
                createCardResponse.getCardId(),
                createCardResponse.getCardName(),
                createCardResponse.getCardPlacement(),
                createCardResponse.getCardStatusEffect(),
                createCardResponse.getGraphicTextureName(),
                createCardResponse.getDamage(),
                createCardResponse.getHp()
        );
    }
}
