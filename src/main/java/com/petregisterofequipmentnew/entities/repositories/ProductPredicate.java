package com.petregisterofequipmentnew.entities.repositories;

import com.petregisterofequipmentnew.ColorEquipment;
import com.petregisterofequipmentnew.TypeEquipmentEnum;
import com.petregisterofequipmentnew.entities.QProduct;
import com.petregisterofequipmentnew.others.DirectionSort;
import com.petregisterofequipmentnew.others.ParametersSort;
import com.querydsl.core.types.dsl.BooleanExpression;

public class ProductPredicate {

    public BooleanExpression buildPredicate(String nameProduct, TypeEquipmentEnum typeEquipmentEnum,
                                            ColorEquipment colorEquipment,
                                            Integer price, Integer size, Boolean isAvailability, Integer countsDoor,
                                            String typeCompressor, Integer sizeDustCollect, Integer countsRegime,
                                            String typeProcessor,
                                            String category, Integer memoryPhone, Integer countsSnaps, String technology) {
        QProduct product = QProduct.product;
        BooleanExpression booleanExpression = product.nameProduct.eq(nameProduct);

        booleanExpression = commonCharacteristicsProduct(booleanExpression, product, typeEquipmentEnum, colorEquipment, price, size, isAvailability);
        if (typeEquipmentEnum != null) {
            booleanExpression = individualAttributesProducts(booleanExpression, typeEquipmentEnum, product, countsDoor, typeCompressor, sizeDustCollect,
                    countsRegime, typeProcessor, category, memoryPhone, countsSnaps, technology);
        }
        return booleanExpression;
    }

    private BooleanExpression commonCharacteristicsProduct(BooleanExpression booleanExpression, QProduct product,
                                                           TypeEquipmentEnum typeEquipmentEnum, ColorEquipment colorEquipment,
                                                           Integer price, Integer size, Boolean isAvailability) {
        if (typeEquipmentEnum != null) {
            booleanExpression = booleanExpression.and(product.nameTypeTechnic.eq(typeEquipmentEnum));
        }
        if (colorEquipment != null) {
            booleanExpression = booleanExpression.and(product.attributes.color.eq(colorEquipment));
        }
        if (price != null) {
            booleanExpression = booleanExpression.and(product.attributes.price.eq(price));
        }
        if (size != null) {
            booleanExpression = booleanExpression.and(product.attributes.size.eq(size));
        }
        if (isAvailability != null) {
            booleanExpression = booleanExpression.and(product.attributes.isAvailabilityProducts.eq(isAvailability));
        }
        return booleanExpression;
    }

    private BooleanExpression individualAttributesProducts(BooleanExpression booleanExpression, TypeEquipmentEnum typeEquipmentEnum,
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
    }

}
