package com.petregisterofequipmentnew.petregisterofequipmentnew.mappers;

import com.petregisterofequipmentnew.petregisterofequipmentnew.dtos.ProductDto;
import com.petregisterofequipmentnew.petregisterofequipmentnew.entities.Product;

public interface ProductMapper {

    Product convertDtoToProduct(ProductDto productDto);
    ProductDto convertProductToDto(Product product);

}
