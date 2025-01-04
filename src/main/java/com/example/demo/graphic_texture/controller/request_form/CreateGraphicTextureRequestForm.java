package com.example.demo.graphic_texture.controller.request_form;

import com.example.demo.card.service.request.CreateCardRequest;
import com.example.demo.graphic_texture.service.request.CreateGraphicTextureRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CreateGraphicTextureRequestForm {
    private final int graphicTextureKindsNumber;
    private final int cardNumber;

    public CreateGraphicTextureRequest toCreateGraphicTextureRequest() {
        return new CreateGraphicTextureRequest(this.graphicTextureKindsNumber, this.cardNumber);
    }
}
