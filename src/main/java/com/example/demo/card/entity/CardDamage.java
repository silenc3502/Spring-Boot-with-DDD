package com.example.demo.card.entity;

import com.example.demo.graphic_texture.entity.GraphicTexture;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class CardDamage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int damage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "graphic_texture_id", nullable = false)
    private GraphicTexture graphicTexture;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "card_id", nullable = false)
    private Card card;

    public CardDamage() {}

    public CardDamage(int damage, GraphicTexture graphicTexture, Card card) {
        this.damage = damage;
        this.graphicTexture = graphicTexture;
        this.card = card;
    }
}
