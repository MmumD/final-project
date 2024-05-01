package kz.sdu.finalproject.cards.dto;

import kz.sdu.finalproject.cards.enums.CardType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CardView {

    private CardType type;
    private String number;

}
