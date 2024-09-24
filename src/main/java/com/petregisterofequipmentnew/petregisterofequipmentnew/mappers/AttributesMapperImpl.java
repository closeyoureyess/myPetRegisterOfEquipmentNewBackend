package com.petregisterofequipmentnew.petregisterofequipmentnew.mappers;

import com.petregisterofequipmentnew.petregisterofequipmentnew.dtos.AttributesDto;
import com.petregisterofequipmentnew.petregisterofequipmentnew.dtos.ProductDto;
import com.petregisterofequipmentnew.petregisterofequipmentnew.entities.Attributes;
import com.petregisterofequipmentnew.petregisterofequipmentnew.entities.Product;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.LinkedList;
import java.util.List;

@Component
@Validated
public class AttributesMapperImpl implements AttributesMapper {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public Attributes convertDtoToAttributes(@NotNull AttributesDto attributesDto) {
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
        if (attributesDto.getProductDtoList() != null) {
            attributes.setProductList(transferProductDtoListToProduct(
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
    public AttributesDto convertAttributesToDto(@NotNull Attributes attributes) {
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
        if (attributes.getProductList() != null) {
            attributesDto.setProductDtoList(transferProductListToProductDto(
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
    public List<Product> transferProductDtoListToProduct(@NotNull List<ProductDto> productDtoList) {
        List<Product> productList = new LinkedList<>();
        for (ProductDto productDto : productDtoList) {
            productList.add(productMapper.convertDtoToProduct(productDto));
        }
        return productList;
    }

    @Override
    public List<ProductDto> transferProductListToProductDto(@NotNull List<Product> productList) {
        List<ProductDto> productDtoList = new LinkedList<>();
        for (Product product : productList) {
            productDtoList.add(productMapper.convertProductToDto(product));
        }
        return productDtoList;
    }

}
