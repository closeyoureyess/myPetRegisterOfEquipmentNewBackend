package com.petregisterofequipmentnew.mappers;

import com.petregisterofequipmentnew.dtos.AttributesDto;
import com.petregisterofequipmentnew.entities.Attributes;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
public interface AttributesMapper {

    Attributes convertDtoToAttributes(@NotNull AttributesDto attributesDto);
    AttributesDto convertAttributesToDto(@NotNull Attributes attributes);

}
