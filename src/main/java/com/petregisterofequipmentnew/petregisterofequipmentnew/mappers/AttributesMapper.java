package com.petregisterofequipmentnew.petregisterofequipmentnew.mappers;

import com.petregisterofequipmentnew.petregisterofequipmentnew.dtos.AttributesDto;
import com.petregisterofequipmentnew.petregisterofequipmentnew.dtos.ProductDto;
import com.petregisterofequipmentnew.petregisterofequipmentnew.entities.Attributes;
import com.petregisterofequipmentnew.petregisterofequipmentnew.entities.Product;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public interface AttributesMapper {

    Attributes convertDtoToAttributes(@NotNull AttributesDto attributesDto);
    AttributesDto convertAttributesToDto(@NotNull Attributes attributes);

}
