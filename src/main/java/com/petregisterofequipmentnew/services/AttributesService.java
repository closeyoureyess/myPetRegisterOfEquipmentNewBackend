package com.petregisterofequipmentnew.services;

import com.petregisterofequipmentnew.entities.Attributes;
import com.petregisterofequipmentnew.others.ContainerObject;
import com.petregisterofequipmentnew.dtos.AttributesDto;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

@Validated
public interface AttributesService {

    AttributesDto createAttributes(@NotNull AttributesDto attributesDto);
    Optional<ContainerObject<Attributes, AttributesDto>> verifyThatAttributesAlreadyExists(@NotNull AttributesDto attributesDto);

}
