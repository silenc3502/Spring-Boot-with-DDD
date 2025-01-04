package com.example.demo.graphic_texture.service.response;

import com.example.demo.game.service.response.CreateSimpleGameResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CreateGraphicTextureResponse {
    private final String graphicTextureName;
    private final int positionX;
    private final int positionY;

    public static CreateGraphicTextureResponse from(String graphicTextureName, int positionX, int positionY) {
        return new CreateGraphicTextureResponse(graphicTextureName, positionX, positionY);
    }
}
