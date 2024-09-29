package com.petregisterofequipmentnew.back.mappers;

import com.petregisterofequipmentnew.back.dtos.AttributesDto;
import com.petregisterofequipmentnew.back.entities.Attributes;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
public interface AttributesMapper {

    Attributes convertDtoToAttributes(@NotNull AttributesDto attributesDto);
    AttributesDto convertAttributesToDto(@NotNull Attributes attributes);

}
