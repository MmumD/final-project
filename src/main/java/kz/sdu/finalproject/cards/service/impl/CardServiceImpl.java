package kz.sdu.finalproject.cards.service.impl;

import kz.sdu.finalproject.cards.dto.CardCreateRequest;
import kz.sdu.finalproject.cards.dto.CardView;
import kz.sdu.finalproject.cards.entity.CardEntity;
import kz.sdu.finalproject.cards.enums.CardType;
import kz.sdu.finalproject.cards.mapper.CardMapper;
import kz.sdu.finalproject.cards.repository.CardRepository;
import kz.sdu.finalproject.cards.service.CardService;
import kz.sdu.finalproject.core.exceptions.BadRequestException;
import kz.sdu.finalproject.user.entity.UserEntity;
import kz.sdu.finalproject.user.service.UserService;
import kz.sdu.finalproject.user.util.GetUsername;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final GetUsername getUsername;

    private final CardRepository cardRepository;

    private final UserService service;

    @Transactional
    @Override
    public boolean createCard(String token, CardCreateRequest request) {
        if (request.getNumber().length() != 19 || !request.getNumber().matches("\\d{4} \\d{4} \\d{4} \\d{4}"))
            throw new BadRequestException("Card number should be in this form: xxxx xxxx xxxx xxxx");

        if(request.getExpirationMonth().length() != 2)
            throw new BadRequestException("Expiration month not correct");

        if(request.getExpirationYear().length() != 2)
            throw new BadRequestException("Expiration year not correct");

        if(request.getCvv().length() != 3)
            throw new BadRequestException("CVV should have 3 numbers");

        if(!request.getExpirationMonth().matches("\\d+"))
            throw new BadRequestException("Expiration month should contain only digits");

        if(!request.getExpirationYear().matches("\\d+"))
            throw new BadRequestException("Expiration year should contain only digits");

        if(!request.getCvv().matches("\\d+"))
            throw new BadRequestException("CVV should contain only digits");

        CardEntity entity = CardMapper.INSTANCE.toEntity(request);

        entity.setType(cardType(request.getNumber()));

        UserEntity user = service.getUserByName(getUsername.getUsername(token));

        entity.setUser(user);

        cardRepository.save(entity);

        return true;
    }

    @Transactional(readOnly = true)
    @Override
    public List<CardView> getUserCards(String token) {
        UserEntity user = service.getUserByName(getUsername.getUsername(token));

        return cardRepository.findCardEntitiesByUser(user)
                .map(CardMapper.INSTANCE::toView)
                .stream()
                .toList();
    }

    private CardType cardType(String number){
        String firstDigit = number.substring(0, 1);

        return switch (firstDigit) {
            case "4" -> CardType.Visa;
            case "5" -> CardType.MasterCard;
            case "6" -> CardType.Maestro;
            default -> throw new BadRequestException("Card type not supported");
        };
    }
}
