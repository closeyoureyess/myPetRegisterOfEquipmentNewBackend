package com.petregisterofequipmentnew.petregisterofequipmentnew.controllers;

import com.petregisterofequipmentnew.petregisterofequipmentnew.ColorEquipment;
import com.petregisterofequipmentnew.petregisterofequipmentnew.TypeEquipmentEnum;
import com.petregisterofequipmentnew.petregisterofequipmentnew.dtos.ProductDto;
import com.petregisterofequipmentnew.petregisterofequipmentnew.others.DirectionSort;
import com.petregisterofequipmentnew.petregisterofequipmentnew.others.ParametersSort;
import com.petregisterofequipmentnew.petregisterofequipmentnew.others.exeptions.MainException;
import com.petregisterofequipmentnew.petregisterofequipmentnew.services.ProductService;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/product")
@Validated
public class ProductContoller {

    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<ProductDto> addModel(@RequestBody ProductDto productDto) throws MainException {
        ProductDto localProductDto = productService.createProduct(productDto);
        if (localProductDto != null) {
            return ResponseEntity.ok(localProductDto);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/gen-info/{nameProduct}")
    public ResponseEntity<List<ProductDto>> getModel(@PathVariable(value = "nameProduct") @NotNull String nameProduct,
                                                     @RequestParam(value = "typeOfEquipment", required = false) TypeEquipmentEnum typeEquipmentEnum,
                                                     @RequestParam(value = "color", required = false) ColorEquipment colorEquipment,
                                                     @RequestParam(value = "price", required = false) @PositiveOrZero Integer price,
                                                     @RequestParam(value = "size", required = false) @PositiveOrZero Integer size,
                                                     @RequestParam(value = "isAvailability", required = false) Boolean isAvailability,
                                                     @RequestParam(value = "offset", defaultValue = "0") @Min(0) Integer offset,
                                                     @RequestParam(value = "limit", defaultValue = "10") @Min(1) @Max(100) Integer limit,
                                                     @RequestParam(value = "sortBy", defaultValue = "alphabet") ParametersSort parametersSort,
                                                     @RequestParam(value = "sortOrder", defaultValue = "asc") DirectionSort directionSort
    ) throws MainException {
        Optional<List<ProductDto>> optionalProductDtoList = productService.getFilteredModels(nameProduct, typeEquipmentEnum, colorEquipment, price, size, isAvailability, offset, limit, parametersSort, directionSort);
        if (optionalProductDtoList.isPresent()) {
            return ResponseEntity.ok(optionalProductDtoList.get());
        }
        return ResponseEntity.notFound().build();
    }

}
