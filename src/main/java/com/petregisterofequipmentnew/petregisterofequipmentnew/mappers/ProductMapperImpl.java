package com.petregisterofequipmentnew.petregisterofequipmentnew.mappers;

import com.petregisterofequipmentnew.petregisterofequipmentnew.dtos.ProductDto;
import com.petregisterofequipmentnew.petregisterofequipmentnew.entities.Product;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@Validated
public class ProductMapperImpl implements ProductMapper {

    @Autowired
    private AttributesMapperImpl attributesMapperImpl;

    @Override
    public Product convertDtoToProduct(@NotNull ProductDto productDto) {
        Product product = new Product();
        if (productDto.getNameTypeTechnic() != null) {
            product.setNameTypeTechnic(productDto.getNameTypeTechnic());
        }
        if (productDto.getManufacturerCountry() != null) {
            product.setManufacturerCountry(productDto.getManufacturerCountry());
        }
        if (productDto.getManufacturerCompany() != null) {
            product.setManufacturerCompany(productDto.getManufacturerCompany());
        }
        if (productDto.getIsOrderOnline() != null) {
            product.setIsOrderOnline(productDto.getIsOrderOnline());
        }
        if (productDto.getIsPossibilityInstallments() != null) {
            product.setIsPossibilityInstallments(productDto.getIsPossibilityInstallments());
        }
        if (productDto.getAttributesDto() != null) {
            product.setAttributes(attributesMapperImpl.convertDtoToAttributes(productDto.getAttributesDto()));
        }
        if (productDto.getCountsDoor() != null) {
            product.setCountsDoor(productDto.getCountsDoor());
        }
        if (productDto.getTypeCompressor() != null) {
            product.setTypeCompressor(productDto.getTypeCompressor());
        }
        if (productDto.getSizeDustCollect() != null) {
            product.setSizeDustCollect(productDto.getSizeDustCollect());
        }
        if (productDto.getCountsRegime() != null) {
            product.setCountsRegime(productDto.getCountsRegime());
        }
        if (productDto.getCategory() != null) {
            product.setCategory(productDto.getCategory());
        }
        if (productDto.getMemoryPhone() != null) {
            product.setMemoryPhone(productDto.getMemoryPhone());
        }
        if (productDto.getCountsSnaps() != null) {
            product.setCountsSnaps(productDto.getCountsSnaps());
        }
        if (productDto.getTechnology() != null) {
            product.setTechnology(productDto.getTechnology());
        }
        if (productDto.getServiceFlag() != null) {
            product.setServiceFlag(productDto.getServiceFlag());
        }
        return product;
    }

    @Override
    public ProductDto convertProductToDto(@NotNull Product product) {
        ProductDto productDto = new ProductDto();
        if (product.getId() != null) {
            productDto.setId(product.getId());
        }
        if (product.getNameTypeTechnic() != null) {
            productDto.setNameTypeTechnic(product.getNameTypeTechnic());
        }
        if (product.getManufacturerCountry() != null) {
            productDto.setManufacturerCountry(product.getManufacturerCountry());
        }
        if (product.getManufacturerCompany() != null) {
            productDto.setManufacturerCompany(product.getManufacturerCompany());
        }
        if (product.getIsOrderOnline() != null) {
            productDto.setIsOrderOnline(product.getIsOrderOnline());
        }
        if (product.getIsPossibilityInstallments() != null) {
            productDto.setIsPossibilityInstallments(product.getIsPossibilityInstallments());
        }
        if (product.getAttributes() != null) {
            productDto.setAttributesDto(attributesMapperImpl.convertAttributesToDto(product.getAttributes()));
        }
        if (product.getCountsDoor() != null) {
            productDto.setCountsDoor(product.getCountsDoor());
        }
        if (product.getTypeCompressor() != null) {
            productDto.setTypeCompressor(product.getTypeCompressor());
        }
        if (product.getSizeDustCollect() != null) {
            productDto.setSizeDustCollect(product.getSizeDustCollect());
        }
        if (product.getCountsRegime() != null) {
            productDto.setCountsRegime(product.getCountsRegime());
        }
        if (product.getTypeProcessor() != null) {
            productDto.setTypeProcessor(product.getTypeProcessor());
        }
        if (product.getCategory() != null) {
            productDto.setCategory(product.getCategory());
        }
        if (product.getMemoryPhone() != null) {
            productDto.setMemoryPhone(product.getMemoryPhone());
        }
        if (product.getCountsSnaps() != null) {
            productDto.setCountsSnaps(product.getCountsSnaps());
        }
        if (product.getTechnology() != null) {
            productDto.setTechnology(product.getTechnology());
        }
        if (product.getServiceFlag() != null) {
            productDto.setServiceFlag(product.getServiceFlag());
        }
        return productDto;
    }
}
