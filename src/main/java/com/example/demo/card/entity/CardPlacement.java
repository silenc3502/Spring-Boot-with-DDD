package com.example.demo.card.entity;

public enum CardPlacement {
    HAND(1),       // 손패
    FIELD(2),      // 필드
    GRAVEYARD(3),  // 무덤
    LOST_ZONE(4);  // 로스트존

    private final int value;

    CardPlacement(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static String getNameByValue(int value) {
        for (CardPlacement placement : CardPlacement.values()) {
            if (placement.value == value) {
                return placement.name();
            }
        }
        return "UNKNOWN";
    }

    public static int getValueByName(String name) {
        try {
            return CardPlacement.valueOf(name.toUpperCase()).value;
        } catch (IllegalArgumentException e) {
            return -1;
        }
    }
}

