package com.example.demo.card.entity;

import java.util.HashMap;
import java.util.Map;

public class CardHpMap {
    private static final Map<CardName, Integer> cardHpMap = new HashMap<>();

    static {
        cardHpMap.put(CardName.FIRE_DRAGON, 3);
        cardHpMap.put(CardName.WATER_SPIRIT, 2);
        cardHpMap.put(CardName.EARTH_GOLEM, 3);
        cardHpMap.put(CardName.WIND_WARRIOR, 3);
        cardHpMap.put(CardName.LIGHT_PRIEST, 3);
        cardHpMap.put(CardName.DARK_ASSASSIN, 3);
        cardHpMap.put(CardName.THUNDER_GIANT, 3);
        cardHpMap.put(CardName.ICE_QUEEN, 2);
        cardHpMap.put(CardName.PHOENIX, 4);
        cardHpMap.put(CardName.SHADOW_BEAST, 3);
    }

    public static int getHpByCardId(int cardNumber) {
        CardName cardName = CardName.getByValue(cardNumber);
        return cardHpMap.getOrDefault(cardName, 0);
    }

    public static int getHpByCardName(String cardName) {
        try {
            CardName card = CardName.valueOf(cardName.toUpperCase());
            return cardHpMap.getOrDefault(card, 0);
        } catch (IllegalArgumentException e) {
            return 0;
        }
    }
}
