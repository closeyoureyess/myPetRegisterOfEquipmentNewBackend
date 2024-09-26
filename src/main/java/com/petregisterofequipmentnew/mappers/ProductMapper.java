package com.petregisterofequipmentnew.mappers;

import com.petregisterofequipmentnew.dtos.ProductDto;
import com.petregisterofequipmentnew.entities.Product;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public interface ProductMapper {

    Product convertDtoToProduct(@NotNull ProductDto productDto);

    ProductDto convertProductToDto(@NotNull Product product);

    List<Product> transferProductDtoListToProduct(@NotNull List<ProductDto> productDtoList);

    List<ProductDto> transferProductListToProductDto(@NotNull List<Product> productList);

}
