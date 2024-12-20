package com.example.demo.graphic_texture.service.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CreateGraphicTextureRequest {
    private final int graphicTextureKindsNumber;
    private final int cardNumber;
}
