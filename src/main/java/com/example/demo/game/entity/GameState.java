package com.example.demo.game.entity;

public enum GameState {
    WINNER(1),
    DRAW(2),
    NOT_FINISH(3);

    private final int value;

    GameState(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static GameState fromValue(int value) {
        for (GameState state : values()) {
            if (state.value == value) {
                return state;
            }
        }
        throw new IllegalArgumentException("Invalid GameState value: " + value);
    }
}
