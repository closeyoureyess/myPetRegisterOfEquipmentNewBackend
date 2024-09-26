package com.petregisterofequipmentnew.services;

import com.petregisterofequipmentnew.TypeEquipmentEnum;
import com.petregisterofequipmentnew.others.ParametersSort;
import com.petregisterofequipmentnew.others.exeptions.MainException;
import com.petregisterofequipmentnew.ColorEquipment;
import com.petregisterofequipmentnew.dtos.ProductDto;
import com.petregisterofequipmentnew.others.DirectionSort;

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
    ProductDto changePosition(ProductDto productDto);
    boolean deletePosition(Integer idModel);

}
