package com.petregisterofequipmentnew.petregisterofequipmentnew.controllers;

import com.petregisterofequipmentnew.petregisterofequipmentnew.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/product")
public class ProductContoller {

    @Autowired
    private ProductService productService;



}
