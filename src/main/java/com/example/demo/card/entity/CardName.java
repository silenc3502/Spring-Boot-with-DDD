package com.example.demo.card.entity;

public enum CardName {
    FIRE_DRAGON(1),
    WATER_SPIRIT(2),
    EARTH_GOLEM(3),
    WIND_WARRIOR(4),
    LIGHT_PRIEST(5),
    DARK_ASSASSIN(6),
    THUNDER_GIANT(7),
    ICE_QUEEN(8),
    PHOENIX(9),
    SHADOW_BEAST(10);

    private final int value;

    CardName(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    // 번호로 CardName을 반환하는 메서드 추가
    public static CardName getByValue(int value) {
        for (CardName cardName : CardName.values()) {
            if (cardName.value == value) {
                return cardName;
            }
        }
        throw new IllegalArgumentException("Invalid card number: " + value);
    }

    public static String getNameByValue(int value) {
        for (CardName cardName : CardName.values()) {
            if (cardName.value == value) {
                return cardName.name();
            }
        }
        return "UNKNOWN";
    }

    public static int getValueByName(String name) {
        try {
            return CardName.valueOf(name.toUpperCase()).value;
        } catch (IllegalArgumentException e) {
            return -1;
        }
    }
}
