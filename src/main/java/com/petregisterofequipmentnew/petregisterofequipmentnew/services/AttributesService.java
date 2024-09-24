package com.petregisterofequipmentnew.petregisterofequipmentnew.services;

import com.petregisterofequipmentnew.petregisterofequipmentnew.dtos.AttributesDto;
import com.petregisterofequipmentnew.petregisterofequipmentnew.entities.Attributes;
import com.petregisterofequipmentnew.petregisterofequipmentnew.others.ContainerObject;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.Optional;

public interface AttributesService {

    Optional<ContainerObject<Attributes, AttributesDto>> verifyThatAttributes(@NotNull AttributesDto attributesDto);

}
