package com.example.demo.card.service;

import com.example.demo.card.entity.*;
import com.example.demo.card.repository.CardDamageRepository;
import com.example.demo.card.repository.CardHpRepository;
import com.example.demo.card.repository.CardIllustrationRepository;
import com.example.demo.card.repository.CardRepository;
import com.example.demo.card.service.request.CreateCardRequest;
import com.example.demo.card.service.response.CreateCardResponse;
import com.example.demo.graphic_texture.entity.GraphicTexture;
import com.example.demo.graphic_texture.repository.GraphicTextureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {
    final private CardRepository cardRepository;
    final private CardDamageRepository cardDamageRepository;
    final private CardHpRepository cardHpRepository;
    final private CardIllustrationRepository cardIllustrationRepository;
    final private GraphicTextureRepository graphicTextureRepository;

    @Override
    public CreateCardResponse createCard(CreateCardRequest createCardRequest) {
        int cardNumber = createCardRequest.getCardNumber();
        CardName cardName;

        try {
            cardName = CardName.getByValue(cardNumber);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid card number provided: " + cardNumber);
        }

        Card card = new Card(cardName, CardPlacement.HAND, CardStatusEffect.NORMAL);
        Card savedCard = cardRepository.save(card);

        Optional<GraphicTexture> existingGraphicTexture = graphicTextureRepository.findByCardNumber(cardNumber);
        GraphicTexture graphicTexture = null;

        if (existingGraphicTexture.isPresent()) {
            graphicTexture = existingGraphicTexture.get();
        }

        CardIllustration cardIllustration = new CardIllustration(graphicTexture, savedCard);
        cardIllustrationRepository.save(cardIllustration);

        int cardDamageValue = CardDamageMap.getDamageByCardId(cardNumber);
        CardDamage cardDamage = new CardDamage(cardDamageValue, graphicTexture, savedCard);
        cardDamageRepository.save(cardDamage);

        int cardHpValue = CardHpMap.getHpByCardId(cardNumber);
        CardHp cardHp = new CardHp(cardHpValue, graphicTexture, savedCard);
        cardHpRepository.save(cardHp);

        return new CreateCardResponse(
                savedCard.getId(),
                savedCard.getName().name(),
                savedCard.getPlacement().name(),
                savedCard.getStatusEffect().name(),
                graphicTexture != null ? graphicTexture.getGraphicTextureName() : "Default",
                cardDamage.getDamage(),
                cardHp.getHp()
        );
    }
}
