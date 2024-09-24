package com.petregisterofequipmentnew.petregisterofequipmentnew.services;

import com.petregisterofequipmentnew.petregisterofequipmentnew.dtos.AttributesDto;

import java.util.Optional;

public interface AttributesService {

    Optional<AttributesDto> verifyThatAttributes(AttributesDto attributesDto);

}
