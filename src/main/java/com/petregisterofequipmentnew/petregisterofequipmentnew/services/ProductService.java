package com.petregisterofequipmentnew.petregisterofequipmentnew.services;

import com.petregisterofequipmentnew.petregisterofequipmentnew.ColorEquipment;
import com.petregisterofequipmentnew.petregisterofequipmentnew.dtos.ProductDto;
import com.petregisterofequipmentnew.petregisterofequipmentnew.others.exeptions.MainException;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    ProductDto createProduct(ProductDto productDto) throws MainException;
    Optional<List<ProductDto>> getPositionPageByPage(String nameModelDto, String typeOfEquipment, ColorEquipment colorEquipment, Integer price,
                                                     Integer offset, Integer limit);
    List<ProductDto> getFilteredModels(
            String nameDevice,
            String typeOfEquipment,
            ColorEquipment colorEquipment,
            Integer price,
            Integer size,
            Boolean isAvailability,
            Integer offset,
            Integer limit,
            String sortBy,
            String sortOrder
    );
    ProductDto changePosition(ProductDto productDto);
    boolean deletePosition(Integer idModel);

}
