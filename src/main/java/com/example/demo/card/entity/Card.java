package com.example.demo.card.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Enumerated(EnumType.STRING)
    private CardPlacement placement;

    @Enumerated(EnumType.STRING)
    private CardStatusEffect statusEffect;

    public Card() {}

    public Card(String name, CardPlacement placement, CardStatusEffect statusEffect) {
        this.name = name;
        this.placement = placement;
        this.statusEffect = statusEffect;
    }
}
