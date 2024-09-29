package com.petregisterofequipmentnew.back.dtos;

import com.petregisterofequipmentnew.back.others.TypeEquipmentEnum;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto implements Serializable {

    private Long id;
    private String nameProduct;
    private TypeEquipmentEnum nameTypeTechnic;
    private String manufacturerCountry;
    private String manufacturerCompany;
    private Boolean isOrderOnline;
    private Boolean isPossibilityInstallments;
    private AttributesDto attributesDto;

}
