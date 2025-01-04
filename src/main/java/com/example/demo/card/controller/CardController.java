package com.example.demo.card.controller;

import com.example.demo.card.controller.request_form.CreateCardRequestForm;
import com.example.demo.card.controller.response_form.CreateCardResponseForm;
import com.example.demo.card.service.CardService;
import com.example.demo.card.service.response.CreateCardResponse;
import com.example.demo.game.controller.request_form.CreateGameRequestForm;
import com.example.demo.game.controller.response_form.CreateSimpleGameResponseForm;
import com.example.demo.game.service.GameService;
import com.example.demo.game.service.response.CreateSimpleGameResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/card")
public class CardController {

    final private CardService cardService;

    @PostMapping("/create")
    public CreateCardResponseForm requestCreateCard(@RequestBody CreateCardRequestForm createCardRequestForm) {
        log.info("requestCreateCard() called");

        CreateCardResponse response = cardService.createCard(createCardRequestForm.toCreateCardRequest());

        return CreateCardResponseForm.from(response);
    }
}
