package com.example.demo.graphic_texture.controller.response_form;

import com.example.demo.graphic_texture.service.response.CreateGraphicTextureResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CreateGraphicTextureResponseForm {
    private final String graphicTextureName;
    private final int positionX;
    private final int positionY;

    public static CreateGraphicTextureResponseForm from(CreateGraphicTextureResponse createGraphicTextureResponse) {
        return new CreateGraphicTextureResponseForm(
                createGraphicTextureResponse.getGraphicTextureName(),
                createGraphicTextureResponse.getPositionX(),
                createGraphicTextureResponse.getPositionY());
    }
}
