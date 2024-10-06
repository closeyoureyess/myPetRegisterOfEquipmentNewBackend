package com.petregisterofequipmentnew.back.mappers;

import com.petregisterofequipmentnew.back.dtos.AttributesDto;
import com.petregisterofequipmentnew.back.dtos.ProductDto;
import com.petregisterofequipmentnew.back.entities.Attributes;
import com.petregisterofequipmentnew.back.entities.Product;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public interface AttributesMapper {

    Attributes convertDtoToAttributes(@NotNull AttributesDto attributesDto);
    AttributesDto convertAttributesToDto(@NotNull Attributes attributes);
    Attributes compareAttributesAndDto(@NotNull Attributes attributes, @NotNull AttributesDto attributesDto);
    List<Attributes> transferAttributesDtoListToAttributes(@NotNull List<AttributesDto> attributesDtoList);
    List<AttributesDto> transferAttributesListToAttributesDto(@NotNull List<Attributes> attributesList);

}
