package com.example.demo.card.entity;

public enum CardStatusEffect {
    NORMAL(0),
    BURN(1),         // 화상
    FREEZE(2),       // 빙결
    STUN(3),         // 스턴
    POISON(4),       // 독
    SLEEP(5),        // 수면
    PARALYSIS(6),    // 마비
    SHIELD(7),       // 보호막
    CURSE(8),        // 저주
    REGENERATION(9); // 재생

    private final int value;

    CardStatusEffect(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static String getNameByValue(int value) {
        for (CardStatusEffect effect : CardStatusEffect.values()) {
            if (effect.value == value) {
                return effect.name();
            }
        }
        return "UNKNOWN";
    }

    public static int getValueByName(String name) {
        try {
            return CardStatusEffect.valueOf(name.toUpperCase()).value;
        } catch (IllegalArgumentException e) {
            return -1;
        }
    }
}

