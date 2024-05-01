package kz.sdu.finalproject.products.dto;

import kz.sdu.finalproject.products.enums.Gender;
import kz.sdu.finalproject.products.enums.ProductType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreateRequest {

    private String name;
    private ProductType type;
    private Gender gender;
    private Double price;

}
