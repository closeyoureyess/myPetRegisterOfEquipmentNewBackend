package com.petregisterofequipmentnew.petregisterofequipmentnew.dtos;

import com.petregisterofequipmentnew.petregisterofequipmentnew.ColorEquipment;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class AttributesDto {

    private Integer id;
    private String nameDevice;
    private Integer serialNumber;
    private ColorEquipment color;
    private Integer size;
    private Integer price;
    private Boolean isAvailabilityProducts;
    private List<ProductDto> productDtoList;

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
