package com.petregisterofequipmentnew.petregisterofequipmentnew.mappers;

import com.petregisterofequipmentnew.petregisterofequipmentnew.dtos.AttributesDto;
import com.petregisterofequipmentnew.petregisterofequipmentnew.dtos.ProductDto;
import com.petregisterofequipmentnew.petregisterofequipmentnew.entities.Attributes;
import com.petregisterofequipmentnew.petregisterofequipmentnew.entities.Product;

import java.util.List;

public interface AttributesMapper {

    Attributes convertDtoToAttributes(AttributesDto attributesDto);
    AttributesDto convertAttributesToDto(Attributes attributes);
    List<Product> transferProductDtoListToProduct(List<ProductDto> productDtoList);
    List<ProductDto> transferProductListToProductDto(List<Product> productList);

}
