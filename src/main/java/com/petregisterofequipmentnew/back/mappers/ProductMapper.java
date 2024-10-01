package com.petregisterofequipmentnew.back.mappers;

import com.petregisterofequipmentnew.back.dtos.ProductDto;
import com.petregisterofequipmentnew.back.entities.Product;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public interface ProductMapper {

    Product convertDtoToProduct(@NotNull ProductDto productDto);

    ProductDto convertProductToDto(@NotNull Product product);

    List<Product> transferProductDtoListToProduct(@NotNull List<ProductDto> productDtoList);

    List<ProductDto> transferProductListToProductDto(@NotNull List<Product> productList);

    ProductDto compareProductAndDto(@NotNull ProductDto productDto, @NotNull Product product);

}
