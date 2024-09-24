package com.petregisterofequipmentnew.petregisterofequipmentnew.mappers;

import com.petregisterofequipmentnew.petregisterofequipmentnew.dtos.ProductDto;
import com.petregisterofequipmentnew.petregisterofequipmentnew.entities.Product;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
public class ProductMapperImpl implements ProductMapper {

    @Autowired
    private AttributesMapper attributesMapper;

    @Override
    public Product convertDtoToProduct(ProductDto productDto) {
        Product product = new Product();
        if (productDto.getId() != null) {
            product.setId(productDto.getId());
        }
        if (productDto.getNameProduct() != null) {
            product.setNameProduct(productDto.getNameProduct());
        }
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
            product.setAttributes(attributesMapper.convertDtoToAttributes(productDto.getAttributesDto()));
        }
        return product;
    }

    @Override
    public ProductDto convertProductToDto(Product product) {
        ProductDto productDto = new ProductDto();
        if (product.getId() != null) {
            productDto.setId(product.getId());
        }
        if (product.getNameProduct() != null) {
            productDto.setNameProduct(product.getNameProduct());
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
            productDto.setAttributesDto(attributesMapper.convertAttributesToDto(product.getAttributes()));
        }
        return productDto;
    }
}
