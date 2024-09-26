package com.petregisterofequipmentnew.petregisterofequipmentnew.services;

import com.petregisterofequipmentnew.petregisterofequipmentnew.ColorEquipment;
import com.petregisterofequipmentnew.petregisterofequipmentnew.TypeEquipmentEnum;
import com.petregisterofequipmentnew.petregisterofequipmentnew.dtos.ProductDto;
import com.petregisterofequipmentnew.petregisterofequipmentnew.others.DirectionSort;
import com.petregisterofequipmentnew.petregisterofequipmentnew.others.ParametersSort;
import com.petregisterofequipmentnew.petregisterofequipmentnew.others.exeptions.MainException;

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
