package com.petregisterofequipmentnew.back.services;

import com.petregisterofequipmentnew.back.entities.Attributes;
import com.petregisterofequipmentnew.back.others.ContainerObject;
import com.petregisterofequipmentnew.back.dtos.AttributesDto;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

@Validated
public interface AttributesService {

    AttributesDto createAttributes(@NotNull AttributesDto attributesDto);
    Optional<ContainerObject<Attributes, AttributesDto>> verifyThatAttributesAlreadyExists(@NotNull AttributesDto attributesDto);

    void deleteAttributes(@NotNull Long id);

}
