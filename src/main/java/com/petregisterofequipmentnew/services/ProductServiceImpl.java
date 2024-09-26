package com.petregisterofequipmentnew.services;

import com.petregisterofequipmentnew.TypeEquipmentEnum;
import com.petregisterofequipmentnew.entities.Attributes;
import com.petregisterofequipmentnew.entities.Product;
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
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
        Page<Product> pageProduct = null;
        Pageable pageable = formingPageRequest(nameProduct, offset, limit, parametersSort, directionSort);
        // 6. typeEquipmentEnum, colorEquipment
        if (typeEquipmentEnum != null && colorEquipment != null && price == null && size == null && isAvailability == null) {
            pageProduct = productRepository.findAllByNameAndTypeTechnicAndColor(nameProduct, typeEquipmentEnum, colorEquipment, pageable);
        }
        // 7. typeEquipmentEnum, price
        else if (typeEquipmentEnum != null && price != null && colorEquipment == null && size == null && isAvailability == null) {
            pageProduct = productRepository.findAllByNameAndTypeTechnicAndPrice(nameProduct, typeEquipmentEnum, price, pageable);
        }
        // 8. typeEquipmentEnum, size
        else if (typeEquipmentEnum != null && size != null && colorEquipment == null && price == null && isAvailability == null) {
            pageProduct = productRepository.findAllByNameAndTypeTechnicAndSize(nameProduct, typeEquipmentEnum, size, pageable);
        }
        // 9. typeEquipmentEnum, isAvailability
        else if (typeEquipmentEnum != null && isAvailability != null && colorEquipment == null && price == null && size == null) {
            pageProduct = productRepository.findAllByNameAndTypeTechnicAndAvailability(nameProduct, typeEquipmentEnum, isAvailability, pageable);
        }
        // 10. colorEquipment, price
        else if (colorEquipment != null && price != null && typeEquipmentEnum == null && size == null && isAvailability == null) {
            pageProduct = productRepository.findAllByNameAndColorAndPrice(nameProduct, colorEquipment, price, pageable);
        }
        // 11. colorEquipment, size
        else if (colorEquipment != null && size != null && typeEquipmentEnum == null && price == null && isAvailability == null) {
            pageProduct = productRepository.findAllByNameAndColorAndSize(nameProduct, colorEquipment, size, pageable);
        }
        // 12. colorEquipment, isAvailability
        else if (colorEquipment != null && isAvailability != null && typeEquipmentEnum == null && price == null && size == null) {
            pageProduct = productRepository.findAllByNameAndColorAndAvailability(nameProduct, colorEquipment, isAvailability, pageable);
        }
        // 13. price, size
        else if (price != null && size != null && typeEquipmentEnum == null && colorEquipment == null && isAvailability == null) {
            pageProduct = productRepository.findAllByNameAndPriceAndSize(nameProduct, price, size, pageable);
        }
        // 14. price, isAvailability
        else if (price != null && isAvailability != null && typeEquipmentEnum == null && colorEquipment == null && size == null) {
            pageProduct = productRepository.findAllByNameAndPriceAndAvailability(nameProduct, price, isAvailability, pageable);
        }
        // 15. size, isAvailability
        else if (size != null && isAvailability != null && typeEquipmentEnum == null && colorEquipment == null && price == null) {
            pageProduct = productRepository.findAllByNameAndSizeAndAvailability(nameProduct, size, isAvailability, pageable);
        }
        // 16. typeEquipmentEnum, colorEquipment, price
        else if (typeEquipmentEnum != null && colorEquipment != null && price != null && size == null && isAvailability == null) {
            pageProduct = productRepository.findAllByNameAndTypeTechnicAndColorAndPrice(nameProduct, typeEquipmentEnum, colorEquipment, price, pageable);
        }
        // 17. typeEquipmentEnum, colorEquipment, size
        else if (typeEquipmentEnum != null && colorEquipment != null && size != null && price == null && isAvailability == null) {
            pageProduct = productRepository.findAllByNameAndTypeTechnicAndColorAndSize(nameProduct, typeEquipmentEnum, colorEquipment, size, pageable);
        }
        // 18. typeEquipmentEnum, colorEquipment, isAvailability
        else if (typeEquipmentEnum != null && colorEquipment != null && isAvailability != null && price == null && size == null) {
            pageProduct = productRepository.findAllByNameAndTypeTechnicAndColorAndAvailability(nameProduct, typeEquipmentEnum, colorEquipment, isAvailability, pageable);
        }
        // 19. typeEquipmentEnum, price, size
        else if (typeEquipmentEnum != null && price != null && size != null && colorEquipment == null && isAvailability == null) {
            pageProduct = productRepository.findAllByNameAndTypeTechnicAndPriceAndSize(nameProduct, typeEquipmentEnum, price, size, pageable);
        }
        // 20. typeEquipmentEnum, price, isAvailability
        else if (typeEquipmentEnum != null && price != null && isAvailability != null && colorEquipment == null && size == null) {
            pageProduct = productRepository.findAllByNameAndTypeTechnicAndPriceAndAvailability(nameProduct, typeEquipmentEnum, price, isAvailability, pageable);
        }
        // 21. typeEquipmentEnum, size, isAvailability
        else if (typeEquipmentEnum != null && size != null && isAvailability != null && colorEquipment == null && price == null) {
            pageProduct = productRepository.findAllByNameAndTypeTechnicAndSizeAndAvailability(nameProduct, typeEquipmentEnum, size, isAvailability, pageable);
        }
        // 22. colorEquipment, price, size
        else if (colorEquipment != null && price != null && size != null && typeEquipmentEnum == null && isAvailability == null) {
            pageProduct = productRepository.findAllByNameAndColorAndPriceAndSize(nameProduct, colorEquipment, price, size, pageable);
        }
        // 23. colorEquipment, price, isAvailability
        else if (colorEquipment != null && price != null && isAvailability != null && typeEquipmentEnum == null && size == null) {
            pageProduct = productRepository.findAllByNameAndColorAndPriceAndAvailability(nameProduct, colorEquipment, price, isAvailability, pageable);
        }
        // 24. colorEquipment, size, isAvailability
        else if (colorEquipment != null && size != null && isAvailability != null && typeEquipmentEnum == null && price == null) {
            pageProduct = productRepository.findAllByNameAndColorAndSizeAndAvailability(nameProduct, colorEquipment, size, isAvailability, pageable);
        }
        // 25. price, size, isAvailability
        else if (price != null && size != null && isAvailability != null && typeEquipmentEnum == null && colorEquipment == null) {
            pageProduct = productRepository.findAllByNameAndPriceAndSizeAndAvailability(nameProduct, price, size, isAvailability, pageable);
        }
        // 26. typeEquipmentEnum, colorEquipment, price, size
        else if (typeEquipmentEnum != null && colorEquipment != null && price != null && size != null && isAvailability == null) {
            pageProduct = productRepository.findAllByNameAndTypeTechnicAndColorAndPriceAndSize(nameProduct, typeEquipmentEnum, colorEquipment, price, size, pageable);
        }
        // 27. typeEquipmentEnum, colorEquipment, price, isAvailability
        else if (typeEquipmentEnum != null && colorEquipment != null && price != null && isAvailability != null && size == null) {
            pageProduct = productRepository.findAllByNameAndTypeTechnicAndColorAndPriceAndAvailability(nameProduct, typeEquipmentEnum, colorEquipment, price, isAvailability, pageable);
        }
        // 28. typeEquipmentEnum, colorEquipment, size, isAvailability
        else if (typeEquipmentEnum != null && colorEquipment != null && size != null && isAvailability != null && price == null) {
            pageProduct = productRepository.findAllByNameAndTypeTechnicAndColorAndSizeAndAvailability(nameProduct, typeEquipmentEnum, colorEquipment, size, isAvailability, pageable);
        }
        // 29. typeEquipmentEnum, price, size, isAvailability
        else if (typeEquipmentEnum != null && price != null && size != null && isAvailability != null && colorEquipment == null) {
            pageProduct = productRepository.findAllByNameAndTypeTechnicAndPriceAndSizeAndAvailability(nameProduct, typeEquipmentEnum, price, size, isAvailability, pageable);
        }
        // 30. colorEquipment, price, size, isAvailability
        else if (colorEquipment != null && price != null && size != null && isAvailability != null && typeEquipmentEnum == null) {
            pageProduct = productRepository.findAllByNameAndColorAndPriceAndSizeAndAvailability(nameProduct, colorEquipment, price, size, isAvailability, pageable);
        }
        // 31. typeEquipmentEnum, colorEquipment, price, size, isAvailability
        else if (typeEquipmentEnum != null && colorEquipment != null && price != null && size != null && isAvailability != null) {
            pageProduct = productRepository.findAllByNameAndTypeTechnicAndColorAndPriceAndSizeAndAvailability(nameProduct, typeEquipmentEnum, colorEquipment, price, size, isAvailability, pageable);
        }

        if (pageProduct == null){
            return Optional.empty();
        } else {
            List<ProductDto> productDtoList = productMapper.transferProductListToProductDto(pageProduct.stream().toList());
            return Optional.of(productDtoList);
        }
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
