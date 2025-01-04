package com.example.demo.card.entity;

import java.util.HashMap;
import java.util.Map;

public class CardIllustrationMap {
    private static final Map<CardName, String> cardIllustrationMap = new HashMap<>();

    static {
        cardIllustrationMap.put(CardName.FIRE_DRAGON, "Fire Dragon Illustration");
        cardIllustrationMap.put(CardName.WATER_SPIRIT, "Water Spirit Illustration");
        cardIllustrationMap.put(CardName.EARTH_GOLEM, "Earth Golem Illustration");
        cardIllustrationMap.put(CardName.WIND_WARRIOR, "Wind Warrior Illustration");
        cardIllustrationMap.put(CardName.LIGHT_PRIEST, "Ligth Priest Illustration");
        cardIllustrationMap.put(CardName.DARK_ASSASSIN, "Dark Assassin Illustration");
        cardIllustrationMap.put(CardName.THUNDER_GIANT, "Thunder Giant Illustration");
        cardIllustrationMap.put(CardName.ICE_QUEEN, "Ice Queen Illustration");
        cardIllustrationMap.put(CardName.PHOENIX, "Phoenix Illustration");
        cardIllustrationMap.put(CardName.SHADOW_BEAST, "Shadow Beast Illustration");
    }

    public static String getHpByCardId(int cardNumber) {
        try {
            CardName cardName = CardName.getByValue(cardNumber);
            return cardIllustrationMap.getOrDefault(cardName, "");
        } catch (IllegalArgumentException e) {
            return "";
        }
    }

    public static String getIllustrationByCardName(String cardName) {
        try {
            CardName card = CardName.valueOf(cardName.toUpperCase());
            return cardIllustrationMap.getOrDefault(card, "");
        } catch (IllegalArgumentException e) {
            return "";
        }
    }
}
