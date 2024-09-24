package com.petregisterofequipmentnew.petregisterofequipmentnew.services;

import com.petregisterofequipmentnew.petregisterofequipmentnew.dtos.AttributesDto;
import com.petregisterofequipmentnew.petregisterofequipmentnew.entities.Attributes;
import com.petregisterofequipmentnew.petregisterofequipmentnew.entities.repositories.AttributesRepository;
import com.petregisterofequipmentnew.petregisterofequipmentnew.mappers.AttributesMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AttributesServiceImpl implements AttributesService {

    @Autowired
    private AttributesRepository attributesRepository;
    @Autowired
    private AttributesMapperImpl attributesMapper;

    @Override
    public Optional<AttributesDto> verifyThatAttributes(AttributesDto attributesDto) {
        Optional<Attributes> optionalAttributes = attributesRepository.findById(attributesDto.getId());
        if (optionalAttributes.isPresent()) {
            return Optional.of(attributesMapper.convertAttributesToDto(optionalAttributes.get()));
        }
        return Optional.empty();
    }
}
