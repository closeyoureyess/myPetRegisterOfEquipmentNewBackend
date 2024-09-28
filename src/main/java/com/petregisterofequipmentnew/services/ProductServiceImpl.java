package com.petregisterofequipmentnew.services;

import com.petregisterofequipmentnew.TypeEquipmentEnum;
import com.petregisterofequipmentnew.entities.Attributes;
import com.petregisterofequipmentnew.entities.Product;
import com.petregisterofequipmentnew.entities.repositories.ProductPredicate;
import com.petregisterofequipmentnew.others.ConstantsClass;
import com.petregisterofequipmentnew.others.ContainerObject;
import com.petregisterofequipmentnew.others.ParametersSort;
import com.petregisterofequipmentnew.others.exeptions.MainException;
import com.petregisterofequipmentnew.others.exeptions.SortNotBeNullException;
import com.petregisterofequipmentnew.ColorEquipment;
import com.petregisterofequipmentnew.dtos.AttributesDto;
import com.petregisterofequipmentnew.dtos.ProductDto;
import com.petregisterofequipmentnew.entities.repositories.ProductRepository;
import com.petregisterofequipmentnew.mappers.ProductMapper;
import com.petregisterofequipmentnew.others.DirectionSort;
import com.petregisterofequipmentnew.others.exeptions.DescriptionExeptions;
import com.querydsl.core.types.Predicate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.*;
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
    @Autowired
    @Qualifier(value = "ProductPredicateImpl")
    private ProductPredicate productPredicate;

    @Override
    public ProductDto createProduct(ProductDto productDto) throws MainException {
        Product productForSaveDB = productMapper.convertDtoToProduct(productDto);
        if (productDto.getAttributesDto().getId() != null) {
            Optional<ContainerObject<Attributes, AttributesDto>> optionalContainerObject =
                    attributesService.verifyThatAttributesAlreadyExists(productDto.getAttributesDto());
            if (!optionalContainerObject.isEmpty() && optionalContainerObject.get().getObjectOne() instanceof Attributes) {
                productForSaveDB.setAttributes(optionalContainerObject.get().getObjectOne());
            }
        }
        return productMapper.convertProductToDto(
                productRepository.save(productForSaveDB)
        );
    }

    @Override
    public Optional<List<ProductDto>> getPositionPageByPage(String nameModelDto, TypeEquipmentEnum typeEquipmentEnum,
                                                            ColorEquipment colorEquipment, Integer price, Integer offset, Integer limit) {
        return Optional.empty();
    }

    @Override
    public Optional<List<ProductDto>> getFilteredModels(String nameProduct, TypeEquipmentEnum typeEquipmentEnum, ColorEquipment colorEquipment,
                                                        Integer price, Integer size, Boolean isAvailability, Integer countsDoor, String typeCompressor, Integer sizeDustCollect, Integer countsRegime, String typeProcessor, String category, Integer memoryPhone, Integer countsSnaps, String technology,
                                                        Integer offset, Integer limit,
                                                        ParametersSort parametersSort, DirectionSort directionSort) throws SortNotBeNullException {
        Pageable pageable = formingPageRequest(nameProduct, offset, limit, parametersSort, directionSort);
        Predicate predicate = productPredicate.buildPredicate(nameProduct, typeEquipmentEnum, colorEquipment, price, size, isAvailability, countsDoor,
                typeCompressor, sizeDustCollect, countsRegime, typeProcessor, category, memoryPhone, countsSnaps, technology);
        Page<Product> pageProduct = productRepository.findAll(predicate, pageable);

        List<ProductDto> productDtoList = productMapper.transferProductListToProductDto(pageProduct.stream().toList());
        return Optional.of(productDtoList);
    }

    @Override
    public ProductDto changePosition(ProductDto productDto) {
        return null;
    }

    @Override
    public boolean deletePosition(Integer idModel) {
        return false;
    }

    private PageRequest formingPageRequest(String nameProduct, Integer offset, Integer limit, ParametersSort parametersSort, DirectionSort directionSort) throws SortNotBeNullException {
        PageRequest pageRequest;
        Sort sort = null;
        if (parametersSort.getParameters().equals(ParametersSort.alphabet.getParameters())) {
            if (directionSort.getDirection().equals(DirectionSort.asc.getDirection())) {
                sort = Sort.by(ConstantsClass.FROM_SORT_FIELD_IS_NAME).ascending();
            } else {
                sort = Sort.by(ConstantsClass.FROM_SORT_FIELD_IS_NAME).descending();
            }
        } else if (parametersSort.getParameters().equals(ParametersSort.cost.getParameters())) {
            if (directionSort.getDirection().equals(DirectionSort.asc.getDirection())) {
                sort = Sort.by(ConstantsClass.FROM_SORT_FIELD_IS_PRICE).ascending();
            } else {
                sort = Sort.by(ConstantsClass.FROM_SORT_FIELD_IS_PRICE).descending();
            }
        }
        if (sort != null) {
            pageRequest = PageRequest.of(offset, limit, sort);
        } else {
            throw new SortNotBeNullException(DescriptionExeptions.GENERATION_ERROR.getDescription(), new SortNotBeNullException(DescriptionExeptions.SORT_FIELD_NOT_BE_NULL.getDescription()));
        }
        return pageRequest;
    }

    private ContainerObject<Page<Product>, Page<ProductDto>> searchProductByName(String nameProduct, ParametersSort parametersSort, Integer offset, Integer limit) {
        PageRequest pageRequest = PageRequest.of(offset, limit);
        Page<Product> productPage = productRepository.findAllByNameProduct(nameProduct, pageRequest); //  Sort.by(parametersSort.getParameters()).ascending()
        List<ProductDto> productList = productMapper.transferProductListToProductDto(productPage.stream().toList());
        Page<ProductDto> productDtoPage = new PageImpl<>(productList, pageRequest, productList.size());
        return new ContainerObject<>(productPage, productDtoPage);
    }
}
