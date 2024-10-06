package com.petregisterofequipmentnew.front.feigns;

import com.petregisterofequipmentnew.back.dtos.AttributesDto;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "attributesFeignClient", url = "http://localhost:8080/api/v1/attributes")
@Validated
public interface AttributesFeignClient {

    @PostMapping("/create")
    ResponseEntity<AttributesDto> createAttributes(@RequestBody @NotNull AttributesDto attributesDto);
    @GetMapping("/find-attributes-nameDevice/{nameDevice}")
    ResponseEntity<List<AttributesDto>> findAttributesByName(@PathVariable String nameDevice,
                                                             @RequestParam(value = "offset", defaultValue = "0") @Min(0) Integer offset,
                                                             @RequestParam(value = "limit", defaultValue = "10") @Min(1) @Max(100) Integer limit);
    @GetMapping("/find-count-attributes-nameDevice/{nameDevice}")
    ResponseEntity<Long> findCountAttributesByName(@PathVariable String nameDevice);
    @DeleteMapping("/delete/{id}")
    ResponseEntity<Boolean> deleteAttributes(@PathVariable @NotNull Long id);

}
