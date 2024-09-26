package com.petregisterofequipmentnew.controllers;

import com.petregisterofequipmentnew.others.ParametersSort;
import com.petregisterofequipmentnew.ColorEquipment;
import com.petregisterofequipmentnew.TypeEquipmentEnum;
import com.petregisterofequipmentnew.dtos.ProductDto;
import com.petregisterofequipmentnew.others.DirectionSort;
import com.petregisterofequipmentnew.others.exeptions.MainException;
import com.petregisterofequipmentnew.services.ProductService;
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
                                                     @RequestParam(value = "countsDoor", required = false) Integer countsDoor,
                                                     @RequestParam(value = "typeCompressor", required = false) String typeCompressor,
                                                     @RequestParam(value = "size_dust_collect", required = false) Integer sizeDustCollect,
                                                     @RequestParam(value = "countsRegime", required = false) Integer countsRegime,
                                                     @RequestParam(value = "typeProcessor", required = false) String typeProcessor,
                                                     @RequestParam(value = "category", required = false) String category,
                                                     @RequestParam(value = "memoryPhone", required = false) Integer memoryPhone,
                                                     @RequestParam(value = "countsSnaps", required = false) Integer countsSnaps,
                                                     @RequestParam(value = "technology", required = false) String technology,
                                                     @RequestParam(value = "offset", defaultValue = "0") @Min(0) Integer offset,
                                                     @RequestParam(value = "limit", defaultValue = "10") @Min(1) @Max(100) Integer limit,
                                                     @RequestParam(value = "sortBy", defaultValue = "alphabet") ParametersSort parametersSort,
                                                     @RequestParam(value = "sortOrder", defaultValue = "asc") DirectionSort directionSort
    ) throws MainException {
        Optional<List<ProductDto>> optionalProductDtoList = productService.getFilteredModels(nameProduct, typeEquipmentEnum,
                colorEquipment, price, size, isAvailability, countsDoor, typeCompressor, sizeDustCollect, countsRegime,typeProcessor,
                category, memoryPhone, countsSnaps, technology, offset, limit, parametersSort, directionSort);
        if (optionalProductDtoList.isPresent()) {
            return ResponseEntity.ok(optionalProductDtoList.get());
        }
        return ResponseEntity.notFound().build();
    }

}
