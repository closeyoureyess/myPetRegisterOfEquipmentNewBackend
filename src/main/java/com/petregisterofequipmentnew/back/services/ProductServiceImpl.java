package com.petregisterofequipmentnew.back.services;

import com.petregisterofequipmentnew.back.others.exeptions.DifferentTypesEquipmentExeption;
import com.petregisterofequipmentnew.back.others.TypeEquipmentEnum;
import com.petregisterofequipmentnew.back.entities.Attributes;
import com.petregisterofequipmentnew.back.entities.Product;
import com.petregisterofequipmentnew.back.entities.repositories.ProductPredicate;
import com.petregisterofequipmentnew.back.others.ConstantsClass;
import com.petregisterofequipmentnew.back.others.ContainerObject;
import com.petregisterofequipmentnew.back.others.ParametersSort;
import com.petregisterofequipmentnew.back.others.exeptions.MainException;
import com.petregisterofequipmentnew.back.others.exeptions.SortNotBeNullException;
import com.petregisterofequipmentnew.back.others.ColorEquipment;
import com.petregisterofequipmentnew.back.dtos.AttributesDto;
import com.petregisterofequipmentnew.back.dtos.ProductDto;
import com.petregisterofequipmentnew.back.entities.repositories.ProductRepository;
import com.petregisterofequipmentnew.back.mappers.ProductMapper;
import com.petregisterofequipmentnew.back.others.DirectionSort;
import com.petregisterofequipmentnew.back.others.exeptions.DescriptionExeptions;
import com.querydsl.core.types.Predicate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.petregisterofequipmentnew.back.others.ConstantsClass.ONE_FLAG;

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
    @Qualifier("productPredicateImpl")
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
        Product product = productRepository.save(productForSaveDB);
        return productMapper.convertProductToDto(product);
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
                                                        ParametersSort parametersSort, DirectionSort directionSort) throws SortNotBeNullException, DifferentTypesEquipmentExeption {
        if (countsDoor != null || typeCompressor != null || sizeDustCollect != null || countsRegime != null || typeProcessor != null
                || category != null || memoryPhone != null || countsSnaps != null || technology != null) {
            checkPairsByAttributes(typeEquipmentEnum, countsDoor, typeCompressor, sizeDustCollect, countsRegime, typeProcessor, category,
                    memoryPhone, countsSnaps, technology);
        }
        Pageable pageable = formingPageRequest(nameProduct, offset, limit, parametersSort, directionSort);
        Page<Product> pageProduct = formingPageFromIfNameProductNullOrNotNull(nameProduct, pageable, colorEquipment, price, size, isAvailability,
                typeEquipmentEnum, countsDoor, typeCompressor, sizeDustCollect, countsRegime, typeProcessor, category, memoryPhone, countsSnaps, technology);
        List<Product> productList = pageProduct.stream().toList();
        List<ProductDto> productDtoList = productMapper.transferProductListToProductDto(productList);
        if (!productDtoList.isEmpty()) {
            return Optional.of(productDtoList);
        }
        return Optional.empty();
    }

    @Override
    public Optional<ProductDto> changePosition(ProductDto productDto) {
        Optional<Product> optionalProductDto = productRepository.findById(productDto.getId());
        if (optionalProductDto.isPresent()) {
            Product afterCompareProduct = productMapper.compareProductAndDto(productDto, optionalProductDto.get());
            return Optional.of(
                    productMapper.convertProductToDto(
                            productRepository.save(afterCompareProduct)
                    )
            );
        }
        return Optional.empty();
    }

    @Override
    public void deletePosition(Integer idModel) {
        productRepository.deleteById(Long.valueOf(idModel));
    }

    private Page<Product> formingPageFromIfNameProductNullOrNotNull(String nameProduct, Pageable pageable, ColorEquipment colorEquipment,
                                                                    Integer price, Integer size, Boolean isAvailability,
                                                                    TypeEquipmentEnum typeEquipmentEnum, Integer countsDoor, String typeCompressor,
                                                                    Integer sizeDustCollect, Integer countsRegime, String typeProcessor,
                                                                    String category, Integer memoryPhone, Integer countsSnaps, String technology) {
        Page<Product> pageProduct = null;
        if (nameProduct == null) {
            pageProduct = productRepository.findAll(pageable);
        }
        if (nameProduct != null) {
            Predicate predicate = productPredicate.buildPredicate(nameProduct, typeEquipmentEnum, colorEquipment, price, size, isAvailability, countsDoor,
                    typeCompressor, sizeDustCollect, countsRegime, typeProcessor, category, memoryPhone, countsSnaps, technology);
            pageProduct = productRepository.findAll(predicate, pageable);
        }
        return pageProduct;
    }

    private void checkPairsByAttributes(TypeEquipmentEnum typeEquipmentEnum, Integer countsDoor, String typeCompressor, Integer sizeDustCollect,
                                        Integer countsRegime, String typeProcessor, String category, Integer memoryPhone, Integer countsSnaps,
                                        String technology) throws DifferentTypesEquipmentExeption {
        Integer result = productPredicate.individualAttributesProducts(ONE_FLAG, typeEquipmentEnum, null, countsDoor, typeCompressor,
                sizeDustCollect, countsRegime, typeProcessor, category, memoryPhone, countsSnaps, technology);
        if (result != null) {
            throw new DifferentTypesEquipmentExeption(DescriptionExeptions.GENERATION_ERROR.getDescription(),
                    new DifferentTypesEquipmentExeption(DescriptionExeptions.DIFFERENT_TYPES_TECHNICS.getDescription()));
        }
    }

    private PageRequest formingPageRequest(String nameProduct, Integer offset, Integer limit, ParametersSort parametersSort, DirectionSort directionSort) throws SortNotBeNullException {
        PageRequest pageRequest;
        Sort sort = null;
        if (parametersSort.getParameters().equals(ParametersSort.alphabet.getParameters())) {
            if (directionSort.getDirection().equals(DirectionSort.asc.getDirection())) {
                sort = Sort.by(ConstantsClass.FROM_SORT_FIELD_IS_TYPE_TECHNIC).ascending();
            } else {
                sort = Sort.by(ConstantsClass.FROM_SORT_FIELD_IS_TYPE_TECHNIC).descending();
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
}
