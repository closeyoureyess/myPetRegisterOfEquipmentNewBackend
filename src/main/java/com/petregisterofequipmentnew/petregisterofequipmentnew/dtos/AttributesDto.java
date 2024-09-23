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
    private String category;
    private Boolean isAvailabilityProducts;
    private List<ProductDto> productDtoList;

}
