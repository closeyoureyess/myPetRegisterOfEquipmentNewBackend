package com.petregisterofequipmentnew.petregisterofequipmentnew.services;

import com.petregisterofequipmentnew.petregisterofequipmentnew.dtos.AttributesDto;
import com.petregisterofequipmentnew.petregisterofequipmentnew.entities.Attributes;
import com.petregisterofequipmentnew.petregisterofequipmentnew.others.ContainerObject;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

@Validated
public interface AttributesService {

    AttributesDto createAttributes(@NotNull AttributesDto attributesDto);
    Optional<ContainerObject<Attributes, AttributesDto>> verifyThatAttributesAlreadyExists(@NotNull AttributesDto attributesDto);

}
