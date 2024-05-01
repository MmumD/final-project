package kz.sdu.finalproject.cards.service;

import kz.sdu.finalproject.cards.dto.CardCreateRequest;
import kz.sdu.finalproject.cards.dto.CardView;

import java.util.List;

public interface CardService {

    boolean createCard(String token, CardCreateRequest request);

    List<CardView> getUserCards(String token);

}
