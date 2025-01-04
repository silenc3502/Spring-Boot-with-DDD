package com.example.demo.graphic_texture.entity;

public enum GraphicTextureKinds {
    CARD_DAMAGE(1, "Card Damage"),
    CARD_HP(2, "Card HP"),
    CARD_ILLUSTRATION(3, "Card Illustration");

    private final int value;
    private final String description;

    GraphicTextureKinds(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    public static GraphicTextureKinds getByValue(int value) {
        for (GraphicTextureKinds kind : GraphicTextureKinds.values()) {
            if (kind.value == value) {
                return kind;
            }
        }
        throw new IllegalArgumentException("No enum constant with value " + value);
    }

    public static String getNameByValue(int value) {
        for (GraphicTextureKinds kind : GraphicTextureKinds.values()) {
            if (kind.value == value) {
                return kind.name();
            }
        }
        return "UNKNOWN";
    }
}
