package com.petregisterofequipmentnew.services.trash;

import com.petregisterofequipmentnew.TypeEquipmentEnum;
import com.petregisterofequipmentnew.entities.QProduct;
import com.querydsl.core.types.dsl.BooleanExpression;

public class CommentsCodeService {

    /*// 6. typeEquipmentEnum, colorEquipment
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
*/


   /* private BooleanExpression individualAttributesProducts(BooleanExpression booleanExpression, TypeEquipmentEnum typeEquipmentEnum,
                                                           QProduct product, Integer countsDoor, String typeCompressor, Integer sizeDustCollect,
                                                           Integer countsRegime, String typeProcessor, String category, Integer memoryPhone,
                                                           Integer countsSnaps, String technology) {
        switch (typeEquipmentEnum) {
            case FRIDGE -> {
                if (countsDoor != null) {
                    booleanExpression = booleanExpression.and(product.attributes.countsDoor.eq(countsDoor));
                }
                if (typeCompressor != null) {
                    booleanExpression = booleanExpression.and(product.attributes.typeCompressor.eq(typeCompressor));
                }
            }
            case HOOVER -> {
                if (sizeDustCollect != null) {
                    booleanExpression = booleanExpression.and(product.attributes.sizeDustCollect.eq(sizeDustCollect));
                }
                if (countsRegime != null) {
                    booleanExpression = booleanExpression.and(product.attributes.countsRegime.eq(countsRegime));
                }
            }
            case PERSONAL_COMPUTER -> {
                if (typeProcessor != null) {
                    booleanExpression = booleanExpression.and(product.attributes.typeCompressor.eq(typeCompressor));
                }
                if (category != null) {
                    booleanExpression = booleanExpression.and(product.attributes.category.eq(category));
                }
            }
            case SMARTPHONE -> {
                if (memoryPhone != null) {
                    booleanExpression = booleanExpression.and(product.attributes.memoryPhone.eq(memoryPhone));
                }
                if (countsSnaps != null) {
                    booleanExpression = booleanExpression.and(product.attributes.countsRegime.eq(countsRegime));
                }
            }
            case TELEVISION -> {
                if (category != null) {
                    booleanExpression = booleanExpression.and(product.attributes.category.eq(category));
                }
                if (technology != null) {
                    booleanExpression = booleanExpression.and(product.attributes.technology.eq(technology));
                }
            }
        }
        return booleanExpression;
    }*/
}
