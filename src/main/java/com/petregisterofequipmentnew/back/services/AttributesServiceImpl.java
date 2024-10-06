package com.petregisterofequipmentnew.back.services;

import com.petregisterofequipmentnew.back.entities.Attributes;
import com.petregisterofequipmentnew.back.mappers.AttributesMapper;
import com.petregisterofequipmentnew.back.others.ContainerObject;
import com.petregisterofequipmentnew.back.dtos.AttributesDto;
import com.petregisterofequipmentnew.back.entities.repositories.AttributesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttributesServiceImpl implements AttributesService {

    @Autowired
    private AttributesRepository attributesRepository;
    @Autowired
    private AttributesMapper attributesMapper;

    @Override
    public AttributesDto createAttributes(AttributesDto attributesDto) {
        Attributes attributes = attributesMapper.convertDtoToAttributes(attributesDto);
        return attributesMapper.convertAttributesToDto(
                attributesRepository.save(attributes)
        );
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

    @Override
    public void deleteAttributes(Long id) {
        attributesRepository.deleteById(id);
    }

    @Override
    public List<AttributesDto> findProductByName(String nameAttributes, Integer offset, Integer limit) {
        Page<Attributes> attributesPage = attributesRepository.findAllByNameDevice(nameAttributes, PageRequest.of(offset, limit));
        return attributesMapper.transferAttributesListToAttributesDto(
                attributesPage.stream().toList()
        );
    }

    @Override
    public Optional<Long> findCountAttributesByName(String nameAttributes) {
        Optional<Long> countNameDevice = attributesRepository.countByNameDevice(nameAttributes);
        if (countNameDevice.isPresent()) {
            return countNameDevice;
        }
        return Optional.empty();
    }
}
