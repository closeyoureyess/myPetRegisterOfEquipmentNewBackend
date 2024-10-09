package com.petregisterofequipmentnew.back.controllers;

import com.petregisterofequipmentnew.back.dtos.AttributesDto;
import com.petregisterofequipmentnew.back.services.AttributesService;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.petregisterofequipmentnew.back.others.ConstantsClass.TEST_VALUE_BOOLEAN;

@RestController
@RequestMapping("api/v1/attributes")
@Validated
@Slf4j
public class AttributesController {

    @Autowired
    private AttributesService attributesService;

    @PostMapping("/create")
    public ResponseEntity<AttributesDto> createAttributes(@RequestBody @NotNull AttributesDto attributesDto) {
        AttributesDto localAttributesDto = attributesService.createAttributes(attributesDto);
        if (localAttributesDto != null) {
            return ResponseEntity.ok(localAttributesDto);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/find-attributes-nameDevice/{nameDevice}")
    public ResponseEntity<List<AttributesDto>> findAttributesByName(@PathVariable String nameDevice,
                                                                    @RequestParam(value = "offset", defaultValue = "0") @Min(0) Integer offset,
                                                                    @RequestParam(value = "limit", defaultValue = "10") @Min(1) @Max(100) Integer limit) {
        log.info("GET findAttributesByName" + nameDevice);
        List<AttributesDto> attributesDtoList = attributesService.findProductByName(nameDevice, offset, limit);
        if (attributesDtoList != null) {
            return ResponseEntity.ok(attributesDtoList);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/find-count-attributes-nameDevice/{nameDevice}")
    public ResponseEntity<Long> findCountAttributesByName(@PathVariable String nameDevice) {
        Optional<Long> countAttributesByName = attributesService.findCountAttributesByName(nameDevice);
        if (countAttributesByName.isPresent()) {
            return ResponseEntity.ok(countAttributesByName.get());
        }
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteAttributes(@PathVariable @NotNull Long id) {
        attributesService.deleteAttributes(id);
        return ResponseEntity.ok(TEST_VALUE_BOOLEAN);
    }

}
