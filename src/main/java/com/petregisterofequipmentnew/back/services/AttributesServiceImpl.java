package com.petregisterofequipmentnew.back.services;

import com.petregisterofequipmentnew.back.entities.Attributes;
import com.petregisterofequipmentnew.back.mappers.AttributesMapperImpl;
import com.petregisterofequipmentnew.back.others.ContainerObject;
import com.petregisterofequipmentnew.back.dtos.AttributesDto;
import com.petregisterofequipmentnew.back.entities.repositories.AttributesRepository;
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
    public AttributesDto createAttributes(AttributesDto attributesDto) {
        Attributes attributes = attributesMapper.convertDtoToAttributes(attributesDto);
        return attributesMapper.convertAttributesToDto(attributesRepository.save(attributes));
    }

    @Override
    public Optional<ContainerObject<Attributes, AttributesDto>> verifyThatAttributesAlreadyExists(AttributesDto attributesDto) {
        Optional<Attributes> optionalAttributes = attributesRepository.findById(attributesDto.getId());
        if (optionalAttributes.isPresent()) {
            AttributesDto attributesDtoAfterDB = attributesMapper.convertAttributesToDto(optionalAttributes.get());
            return Optional.of(new ContainerObject<>(optionalAttributes.get(), attributesDtoAfterDB));
        }
        return Optional.empty();
    }


}
