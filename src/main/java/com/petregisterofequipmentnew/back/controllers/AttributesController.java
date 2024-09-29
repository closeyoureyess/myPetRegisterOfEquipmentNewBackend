package com.petregisterofequipmentnew.back.controllers;

import com.petregisterofequipmentnew.back.dtos.AttributesDto;
import com.petregisterofequipmentnew.back.services.AttributesService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/attributes")
@Validated
public class AttributesController {

    @Autowired
    private AttributesService attributesService;

    @PostMapping("/create")
    public ResponseEntity<AttributesDto> createAttributes(@RequestBody @NotNull AttributesDto attributesDto){
        AttributesDto localAttributesDto = attributesService.createAttributes(attributesDto);
        if (localAttributesDto != null) {
            return ResponseEntity.ok(localAttributesDto);
        }
        return ResponseEntity.badRequest().build();
    }

}
