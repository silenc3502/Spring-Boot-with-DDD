package com.example.demo.graphic_texture.service;

import com.example.demo.card.entity.CardName;
import com.example.demo.graphic_texture.entity.GraphicTexture;
import com.example.demo.graphic_texture.entity.GraphicTextureKinds;
import com.example.demo.graphic_texture.repository.GraphicTextureRepository;
import com.example.demo.graphic_texture.service.request.CreateGraphicTextureRequest;
import com.example.demo.graphic_texture.service.response.CreateGraphicTextureResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GraphicTextureServiceImpl implements GraphicTextureService {
    final private GraphicTextureRepository graphicTextureRepository;

    final int START_X = 150;
    final int START_Y = 100;
    final int GAP_X = 200;

    private int countAllGraphicTextures() {
        return (int) graphicTextureRepository.count();
    }

    // Private method to get CardName by its number
    private CardName getCardNameByNumber(int cardNumber) {
        try {
            return CardName.getByValue(cardNumber);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("유효하지 않은 card 번호: " + cardNumber);
        }
    }

    // Private method to get GraphicTextureKinds by its value
    private GraphicTextureKinds getGraphicTextureKindsByNumber(int graphicTextureKindsNumber) {
        try {
            return GraphicTextureKinds.getByValue(graphicTextureKindsNumber);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("유효하지 않은 graphic texture 종류: " + graphicTextureKindsNumber);
        }
    }

    // Private method to build the graphic texture name
    private String buildGraphicTextureName(CardName cardName, GraphicTextureKinds graphicTextureKinds) {
        return cardName.name() + "_" + graphicTextureKinds.name();
    }

    private int calculatePositionX(long graphicTextureCount) {
        return START_X + (int) (graphicTextureCount * GAP_X);
    }

    @Override
    public CreateGraphicTextureResponse createGraphicTexture(CreateGraphicTextureRequest createGraphicTextureRequest) {
        int graphicTextureCount = countAllGraphicTextures();

        int cardNumber = createGraphicTextureRequest.getCardNumber();
        CardName cardName = getCardNameByNumber(cardNumber);

        int graphicTextureKindsNumber = createGraphicTextureRequest.getGraphicTextureKindsNumber();
        GraphicTextureKinds graphicTextureKinds = getGraphicTextureKindsByNumber(graphicTextureKindsNumber);

        String graphicTextureName = buildGraphicTextureName(cardName, graphicTextureKinds);

        int positionX = calculatePositionX(graphicTextureCount);

        GraphicTexture graphicTexture = new GraphicTexture(cardNumber, graphicTextureName, positionX, START_Y);

        this.graphicTextureRepository.save(graphicTexture);

        return CreateGraphicTextureResponse.from(graphicTextureName, positionX, START_Y);
    }
}
