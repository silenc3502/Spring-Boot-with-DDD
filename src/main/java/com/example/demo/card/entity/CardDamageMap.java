package com.example.demo.card.entity;

import java.util.HashMap;
import java.util.Map;

public class CardDamageMap {
    private static final Map<CardName, Integer> cardDamageMap = new HashMap<>();

    static {
        cardDamageMap.put(CardName.FIRE_DRAGON, 4);
        cardDamageMap.put(CardName.WATER_SPIRIT, 1);
        cardDamageMap.put(CardName.EARTH_GOLEM, 3);
        cardDamageMap.put(CardName.WIND_WARRIOR, 2);
        cardDamageMap.put(CardName.LIGHT_PRIEST, 2);
        cardDamageMap.put(CardName.DARK_ASSASSIN, 3);
        cardDamageMap.put(CardName.THUNDER_GIANT, 4);
        cardDamageMap.put(CardName.ICE_QUEEN, 3);
        cardDamageMap.put(CardName.PHOENIX, 3);
        cardDamageMap.put(CardName.SHADOW_BEAST, 4);
    }

    public static int getDamageByCardId(int cardNumber) {
        CardName cardName = CardName.getByValue(cardNumber);
        return cardDamageMap.getOrDefault(cardName, 0);
    }

    public static int getDamageByCardName(String cardName) {
        try {
            CardName card = CardName.valueOf(cardName.toUpperCase());
            return cardDamageMap.getOrDefault(card, 0);
        } catch (IllegalArgumentException e) {
            return 0;
        }
    }
}
