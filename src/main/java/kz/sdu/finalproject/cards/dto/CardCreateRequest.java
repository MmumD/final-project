package kz.sdu.finalproject.cards.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CardCreateRequest {

    private String number;
    private String expirationMonth;
    private String expirationYear;
    private String cvv;

}
