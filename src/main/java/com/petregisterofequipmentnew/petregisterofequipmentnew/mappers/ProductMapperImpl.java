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
        return productDto;
    }
}
