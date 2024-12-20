package com.example.demo.graphic_texture.entity;

import com.example.demo.game.entity.GameState;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter
@Entity
public class GraphicTexture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int cardNumber;

    private String graphicTextureName;
    private int positionX;
    private int positionY;

    public GraphicTexture() {}

    public GraphicTexture(int cardNumber, String graphicTextureName, int positionX, int positionY) {
        this.cardNumber = cardNumber;
        this.graphicTextureName = graphicTextureName;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }
}
