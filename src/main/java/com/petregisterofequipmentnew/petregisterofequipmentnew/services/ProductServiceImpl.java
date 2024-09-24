package com.petregisterofequipmentnew.petregisterofequipmentnew.services;

import com.petregisterofequipmentnew.petregisterofequipmentnew.ColorEquipment;
import com.petregisterofequipmentnew.petregisterofequipmentnew.dtos.ProductDto;
import com.petregisterofequipmentnew.petregisterofequipmentnew.entities.repositories.ProductRepository;
import com.petregisterofequipmentnew.petregisterofequipmentnew.mappers.ProductMapper;
import com.petregisterofequipmentnew.petregisterofequipmentnew.others.exeptions.MainException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private AttributesService attributesService;

    @Override
    public ProductDto createPosition(ProductDto modelDto) throws MainException {
        if (modelDto.getAttributesDto() != null){
            attributesService.verifyThatAttributes(modelDto.getAttributesDto());
        }
        productRepository.save(productMapper.convertDtoToProduct(modelDto));
        return modelDto;
    }

    @Override
    public Optional<List<ProductDto>> getPositionPageByPage(String nameModelDto, String typeOfEquipment, ColorEquipment colorEquipment, Integer price, Integer offset, Integer limit) {
        return Optional.empty();
    }

    @Override
    public List<ProductDto> getFilteredModels(String nameDevice, String typeOfEquipment, ColorEquipment colorEquipment, Integer price, Integer size, Boolean isAvailability, Integer offset, Integer limit, String sortBy, String sortOrder) {
        return null;
    }

    @Override
    public ProductDto changePosition(ProductDto productDto) {
        return null;
    }

    @Override
    public boolean deletePosition(Integer idModel) {
        return false;
    }


}
