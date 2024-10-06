package com.petregisterofequipmentnew.back.services;

import com.petregisterofequipmentnew.back.others.ColorEquipment;
import com.petregisterofequipmentnew.back.others.DirectionSort;
import com.petregisterofequipmentnew.back.others.ParametersSort;
import com.petregisterofequipmentnew.back.others.exeptions.MainException;
import com.petregisterofequipmentnew.back.others.TypeEquipmentEnum;
import com.petregisterofequipmentnew.back.dtos.ProductDto;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    ProductDto createProduct(ProductDto productDto) throws MainException;
    Optional<List<ProductDto>> getPositionPageByPage(String nameModelDto, TypeEquipmentEnum typeEquipmentEnum, ColorEquipment colorEquipment, Integer price,
                                                     Integer offset, Integer limit);
    Optional<List<ProductDto>> getFilteredModels(
            String nameDevice,
            TypeEquipmentEnum typeEquipmentEnum,
            ColorEquipment colorEquipment,
            Integer price,
            Integer size,
            Boolean isAvailability, Integer countsDoor, String typeCompressor, Integer sizeDustCollect, Integer countsRegime, String typeProcessor, String category, Integer memoryPhone, Integer countsSnaps, String technology,
            Integer offset,
            Integer limit,
            ParametersSort parametersSort,
            DirectionSort directionSort
    ) throws MainException;
    Optional<ProductDto> changePosition(ProductDto productDto);
    void deletePosition(Long idModel);

}
