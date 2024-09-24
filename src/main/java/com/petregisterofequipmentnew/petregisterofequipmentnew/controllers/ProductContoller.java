package com.petregisterofequipmentnew.petregisterofequipmentnew.controllers;

import com.petregisterofequipmentnew.petregisterofequipmentnew.dtos.ProductDto;
import com.petregisterofequipmentnew.petregisterofequipmentnew.others.exeptions.MainException;
import com.petregisterofequipmentnew.petregisterofequipmentnew.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
