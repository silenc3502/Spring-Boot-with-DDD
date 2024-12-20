package com.example.demo.graphic_texture.service;

import com.example.demo.graphic_texture.service.request.CreateGraphicTextureRequest;
import com.example.demo.graphic_texture.service.response.CreateGraphicTextureResponse;

public interface GraphicTextureService {
    CreateGraphicTextureResponse createGraphicTexture(CreateGraphicTextureRequest createGraphicTextureRequest);
}
