package kz.sdu.finalproject.cards.controller;

import kz.sdu.finalproject.cards.dto.CardCreateRequest;
import kz.sdu.finalproject.cards.dto.CardView;
import kz.sdu.finalproject.cards.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/card")
@RequiredArgsConstructor
public class CardController {

    private final CardService service;

    @PostMapping("/register")
    public ResponseEntity<Boolean> registerCard(@RequestHeader("Authorization") String token, @RequestBody CardCreateRequest request){
        return ResponseEntity.ok(service.createCard(token, request));
    }

    @GetMapping("/get-card")
    public ResponseEntity<List<CardView>> getCard(@RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(service.getUserCards(token));
    }

}
