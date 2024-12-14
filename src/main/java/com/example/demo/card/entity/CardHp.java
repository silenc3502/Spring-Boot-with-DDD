package com.example.demo.card.entity;

import com.example.demo.graphic_texture.entity.GraphicTexture;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class CardHp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int hp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "graphic_texture_id", nullable = false)
    private GraphicTexture graphicTexture;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "card_id", nullable = false)
    private Card card;

    public CardHp() {}

    public CardHp(int hp, GraphicTexture graphicTexture, Card card) {
        this.hp = hp;
        this.graphicTexture = graphicTexture;
        this.card = card;
    }
}
