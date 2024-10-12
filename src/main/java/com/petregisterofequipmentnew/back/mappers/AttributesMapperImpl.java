package com.petregisterofequipmentnew.back.mappers;

import com.petregisterofequipmentnew.back.dtos.AttributesDto;
import com.petregisterofequipmentnew.back.entities.Attributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static com.petregisterofequipmentnew.back.others.ConstantsClass.ONE_FLAG;
import static com.petregisterofequipmentnew.back.others.ConstantsClass.ZERO_FLAG;

@Component
public class AttributesMapperImpl implements AttributesMapper {

    @Autowired
    @Lazy
    private ProductMapper productMapper;

    @Override
    public Attributes convertDtoToAttributes(AttributesDto attributesDto) {
        Attributes attributes = new Attributes();
        if (attributesDto.getId() != null) {
            attributes.setId(attributesDto.getId());
        }
        if (attributesDto.getNameDevice() != null) {
            attributes.setNameDevice(attributesDto.getNameDevice());
        }
        if (attributesDto.getSerialNumber() != null) {
            attributes.setSerialNumber(attributesDto.getSerialNumber());
        }
        if (attributesDto.getColor() != null) {
            attributes.setColor(attributesDto.getColor());
        }
        if (attributesDto.getSize() != null) {
            attributes.setSize(attributesDto.getSize());
        }
        if (attributesDto.getPrice() != null) {
            attributes.setPrice(attributesDto.getPrice());
        }
        if (attributesDto.getCategory() != null) {
            attributes.setCategory(attributesDto.getCategory());
        }
        if (attributesDto.getIsAvailabilityProducts() != null) {
            attributes.setIsAvailabilityProducts(attributesDto.getIsAvailabilityProducts());
        }
        if (attributesDto.getProductDtoList() != null && (attributesDto.getServiceFlag() == null || attributesDto.getServiceFlag().equals(ZERO_FLAG))
        ) {
            attributes.setProductList(productMapper.transferProductDtoListToProduct(
                            attributesDto.getProductDtoList()
                    )
            );
        }
        if (attributesDto.getCountsDoor() != null) {
            attributes.setCountsDoor(attributesDto.getCountsDoor());
        }
        if (attributesDto.getTypeCompressor() != null) {
            attributes.setTypeCompressor(attributesDto.getTypeCompressor());
        }
        if (attributesDto.getSizeDustCollect() != null) {
            attributes.setSizeDustCollect(attributesDto.getSizeDustCollect());
        }
        if (attributesDto.getCountsRegime() != null) {
            attributes.setCountsRegime(attributesDto.getCountsRegime());
        }
        if (attributesDto.getTypeProcessor() != null) {
            attributes.setTypeProcessor(attributesDto.getTypeProcessor());
        }
        if (attributesDto.getMemoryPhone() != null) {
            attributes.setMemoryPhone(attributesDto.getMemoryPhone());
        }
        if (attributesDto.getCountsSnaps() != null) {
            attributes.setCountsSnaps(attributesDto.getCountsSnaps());
        }
        if (attributesDto.getTechnology() != null) {
            attributes.setTechnology(attributesDto.getTechnology());
        }
        if (attributesDto.getServiceFlag() != null) {
            attributes.setServiceFlag(attributesDto.getServiceFlag());
        }
        return attributes;
    }

    @Override
    public AttributesDto convertAttributesToDto(Attributes attributes) {
        AttributesDto attributesDto = new AttributesDto();
        if (attributes.getId() != null) {
            attributesDto.setId(attributes.getId());
        }
        if (attributes.getNameDevice() != null) {
            attributesDto.setNameDevice(attributes.getNameDevice());
        }
        if (attributes.getSerialNumber() != null) {
            attributesDto.setSerialNumber(attributes.getSerialNumber());
        }
        if (attributes.getColor() != null) {
            attributesDto.setColor(attributes.getColor());
        }
        if (attributes.getSize() != null) {
            attributesDto.setSize(attributes.getSize());
        }
        if (attributes.getPrice() != null) {
            attributesDto.setPrice(attributes.getPrice());
        }
        if (attributes.getCategory() != null) {
            attributesDto.setCategory(attributes.getCategory());
        }
        if (attributes.getIsAvailabilityProducts() != null) {
            attributesDto.setIsAvailabilityProducts(attributes.getIsAvailabilityProducts());
        }
        if (attributes.getProductList() != null && (attributes.getServiceFlag() == null || attributes.getServiceFlag().equals(ZERO_FLAG))) {
            attributesDto.setProductDtoList(productMapper.transferProductListToProductDto(
                            attributes.getProductList()
                    )
            );
        }
        if (attributes.getCountsDoor() != null) {
            attributesDto.setCountsDoor(attributes.getCountsDoor());
        }
        if (attributes.getTypeCompressor() != null) {
            attributesDto.setTypeCompressor(attributes.getTypeCompressor());
        }
        if (attributes.getSizeDustCollect() != null) {
            attributesDto.setSizeDustCollect(attributes.getSizeDustCollect());
        }
        if (attributes.getCountsRegime() != null) {
            attributesDto.setCountsRegime(attributes.getCountsRegime());
        }
        if (attributes.getTypeProcessor() != null) {
            attributesDto.setTypeProcessor(attributes.getTypeProcessor());
        }
        if (attributes.getMemoryPhone() != null) {
            attributesDto.setMemoryPhone(attributes.getMemoryPhone());
        }
        if (attributes.getCountsSnaps() != null) {
            attributesDto.setCountsSnaps(attributes.getCountsSnaps());
        }
        if (attributes.getTechnology() != null) {
            attributesDto.setTechnology(attributes.getTechnology());
        }
        if (attributes.getServiceFlag() != null) {
            attributesDto.setServiceFlag(attributes.getServiceFlag());
        }
        return attributesDto;
    }

    @Override
    public Attributes compareAttributesAndDto(Attributes attributes, AttributesDto attributesDto) {
        if (attributesDto.getId() != null && attributes.getId() == null) {
            attributes.setId(attributesDto.getId());
        } else if (attributesDto.getId() != null && !attributesDto.getId().equals(attributes.getId())) {
            attributes.setId(attributesDto.getId());
        }

        if (attributesDto.getNameDevice() != null && attributes.getNameDevice() == null) {
            attributes.setNameDevice(attributesDto.getNameDevice());
        } else if (attributesDto.getNameDevice() != null && !attributesDto.getNameDevice().equals(attributes.getNameDevice())) {
            attributes.setNameDevice(attributesDto.getNameDevice());
        }

        if (attributesDto.getSerialNumber() != null && attributes.getSerialNumber() == null) {
            attributes.setSerialNumber(attributesDto.getSerialNumber());
        } else if (attributesDto.getSerialNumber() != null && !attributesDto.getSerialNumber().equals(attributes.getSerialNumber())) {
            attributes.setSerialNumber(attributesDto.getSerialNumber());
        }

        if (attributesDto.getColor() != null && attributes.getColor() == null) {
            attributes.setColor(attributesDto.getColor());
        } else if (attributesDto.getColor() != null && !attributesDto.getColor().equals(attributes.getColor())) {
            attributes.setColor(attributesDto.getColor());
        }

        if (attributesDto.getSize() != null && attributes.getSize() == null) {
            attributes.setSize(attributesDto.getSize());
        } else if (attributesDto.getSize() != null && !attributesDto.getSize().equals(attributes.getSize())) {
            attributes.setSize(attributesDto.getSize());
        }

        if (attributesDto.getPrice() != null && attributes.getPrice() == null) {
            attributes.setPrice(attributesDto.getPrice());
        } else if (attributesDto.getPrice() != null && !attributesDto.getPrice().equals(attributes.getPrice())) {
            attributes.setPrice(attributesDto.getPrice());
        }

        if (attributesDto.getIsAvailabilityProducts() != null && attributes.getIsAvailabilityProducts() == null) {
            attributes.setIsAvailabilityProducts(attributesDto.getIsAvailabilityProducts());
        } else if (attributesDto.getIsAvailabilityProducts() != null && !attributesDto.getIsAvailabilityProducts().equals(attributes.getIsAvailabilityProducts())) {
            attributes.setIsAvailabilityProducts(attributesDto.getIsAvailabilityProducts());
        }

        if (attributesDto.getCountsDoor() != null && attributes.getCountsDoor() == null) {
            attributes.setCountsDoor(attributesDto.getCountsDoor());
        } else if (attributesDto.getCountsDoor() != null && !attributesDto.getCountsDoor().equals(attributes.getCountsDoor())) {
            attributes.setCountsDoor(attributesDto.getCountsDoor());
        }

        if (attributesDto.getTypeCompressor() != null && attributes.getTypeCompressor() == null) {
            attributes.setTypeCompressor(attributesDto.getTypeCompressor());
        } else if (attributesDto.getTypeCompressor() != null && !attributesDto.getTypeCompressor().equals(attributes.getTypeCompressor())) {
            attributes.setTypeCompressor(attributesDto.getTypeCompressor());
        }

        if (attributesDto.getSizeDustCollect() != null && attributes.getSizeDustCollect() == null) {
            attributes.setSizeDustCollect(attributesDto.getSizeDustCollect());
        } else if (attributesDto.getSizeDustCollect() != null && !attributesDto.getSizeDustCollect().equals(attributes.getSizeDustCollect())) {
            attributes.setSizeDustCollect(attributesDto.getSizeDustCollect());
        }
        if (attributesDto.getCountsRegime() != null && attributes.getCountsRegime() == null) {
            attributes.setCountsRegime(attributesDto.getCountsRegime());
        } else if (attributesDto.getCountsRegime() != null && !attributesDto.getCountsRegime().equals(attributes.getCountsRegime())) {
            attributes.setCountsRegime(attributesDto.getCountsRegime());
        }

        if (attributesDto.getTypeProcessor() != null && attributes.getTypeProcessor() == null) {
            attributes.setTypeProcessor(attributesDto.getTypeProcessor());
        } else if (attributesDto.getTypeProcessor() != null && !attributesDto.getTypeProcessor().equals(attributes.getTypeProcessor())) {
            attributes.setTypeProcessor(attributesDto.getTypeProcessor());
        }

        if (attributesDto.getCategory() != null && attributes.getCategory() == null) {
            attributes.setCategory(attributesDto.getCategory());
        } else if (attributesDto.getCategory() != null && !attributesDto.getCategory().equals(attributes.getCategory())) {
            attributes.setCategory(attributesDto.getCategory());
        }

        if (attributesDto.getMemoryPhone() != null && attributes.getMemoryPhone() == null) {
            attributes.setMemoryPhone(attributesDto.getMemoryPhone());
        } else if (attributesDto.getMemoryPhone() != null && !attributesDto.getMemoryPhone().equals(attributes.getMemoryPhone())) {
            attributes.setMemoryPhone(attributesDto.getMemoryPhone());
        }

        if (attributesDto.getCountsSnaps() != null && attributes.getCountsSnaps() == null) {
            attributes.setCountsSnaps(attributesDto.getCountsSnaps());
        } else if (attributesDto.getCountsSnaps() != null && !attributesDto.getCountsSnaps().equals(attributes.getCountsSnaps())) {
            attributes.setCountsSnaps(attributesDto.getCountsSnaps());
        }

        if (attributesDto.getTechnology() != null && attributes.getTechnology() == null) {
            attributes.setTechnology(attributesDto.getTechnology());
        } else if (attributesDto.getTechnology() != null && !attributesDto.getTechnology().equals(attributes.getTechnology())) {
            attributes.setTechnology(attributesDto.getTechnology());
        }
        return attributes;
    }

    @Override
    public List<Attributes> transferAttributesDtoListToAttributes(List<AttributesDto> attributesDtoList) {
        return attributesDtoList.stream().map(this::convertDtoToAttributes).collect(Collectors.toList());
    }

    @Override
    public List<AttributesDto> transferAttributesListToAttributesDto(List<Attributes> attributesList) {
        return attributesList.stream().map(this::convertAttributesToDto).collect(Collectors.toList());
    }

}
