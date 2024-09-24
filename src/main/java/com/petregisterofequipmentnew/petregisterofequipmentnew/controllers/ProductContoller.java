package com.petregisterofequipmentnew.petregisterofequipmentnew.controllers;

import com.petregisterofequipmentnew.petregisterofequipmentnew.ColorEquipment;
import com.petregisterofequipmentnew.petregisterofequipmentnew.TypeEquipmentEnum;
import com.petregisterofequipmentnew.petregisterofequipmentnew.dtos.ProductDto;
import com.petregisterofequipmentnew.petregisterofequipmentnew.others.exeptions.MainException;
import com.petregisterofequipmentnew.petregisterofequipmentnew.services.ProductService;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/product")
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
    public ResponseEntity<List<ProductDto>> getModel(@PathVariable(value = "nameProduct") String nameProduct,
                                                     @RequestParam(value = "typeOfEquipment", required = false) TypeEquipmentEnum typeEquipmentEnum,
                                                     @RequestParam(value = "color", required = false) ColorEquipment colorEquipment,
                                                     @RequestParam(value = "price", required = false) Integer price,
                                                     @RequestParam(value = "size", required = false) Integer size,
                                                     @RequestParam(value = "isAvailability", required = false) Boolean isAvailability,
                                                     @RequestParam(value = "offset", defaultValue = "0") @Min(0) Integer offset,
                                                     @RequestParam(value = "limit", defaultValue = "10") @Min(1) Integer limit,
                                                     @RequestParam(value = "sortBy", defaultValue = "name") String sortBy,
                                                     @RequestParam(value = "sortOrder", defaultValue = "asc") String sortOrder
    ) {
        List<ProductDto> listModel = productService.getFilteredModels(nameProduct, typeEquipmentEnum, colorEquipment, price, size, isAvailability, offset, limit, sortBy, sortOrder);
        if (listModel != null) {
            return ResponseEntity.ok(listModel);
        }
        return ResponseEntity.notFound().build();

    }

}
