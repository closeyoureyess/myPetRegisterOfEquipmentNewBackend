package com.petregisterofequipmentnew.petregisterofequipmentnew.dtos;

import com.petregisterofequipmentnew.petregisterofequipmentnew.TypeEquipmentEnum;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto implements Serializable {

    private Integer id;
    private TypeEquipmentEnum nameTypeTechnic;
    private String manufacturerCountry;
    private String manufacturerCompany;
    private Boolean isOrderOnline;
    private Boolean isPossibilityInstallments;
    private AttributesDto attributesDto;

    private Integer countsDoor;
    private String typeCompressor;
    private Integer sizeDustCollect;
    private Integer countsRegime;
    private String typeProcessor;
    private String category;
    private Integer memoryPhone;
    private Integer countsSnaps;
    private String technology;
    private Integer serviceFlag;

}
