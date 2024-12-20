package com.example.demo.graphic_texture.controller;

import com.example.demo.graphic_texture.controller.request_form.CreateGraphicTextureRequestForm;
import com.example.demo.graphic_texture.controller.response_form.CreateGraphicTextureResponseForm;
import com.example.demo.graphic_texture.service.GraphicTextureService;
import com.example.demo.graphic_texture.service.response.CreateGraphicTextureResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/graphic-texture")
public class GraphicTextureController {

    final private GraphicTextureService graphicTextureService;

    @PostMapping("/create")
    public CreateGraphicTextureResponseForm requestCreateGraphicTexture(@RequestBody CreateGraphicTextureRequestForm createGraphicTextureRequestForm) {
        log.info("requestCreateGraphicTexture() called");

        CreateGraphicTextureResponse response = graphicTextureService.createGraphicTexture(createGraphicTextureRequestForm.toCreateGraphicTextureRequest());

        return CreateGraphicTextureResponseForm.from(response);
    }
}
