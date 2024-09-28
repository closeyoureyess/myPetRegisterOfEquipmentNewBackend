package com.petregisterofequipmentnew.entities.repositories;

import com.petregisterofequipmentnew.ColorEquipment;
import com.petregisterofequipmentnew.TypeEquipmentEnum;
import com.petregisterofequipmentnew.entities.QProduct;
import com.petregisterofequipmentnew.others.DirectionSort;
import com.petregisterofequipmentnew.others.ParametersSort;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;

public class ProductPredicate {

    public BooleanExpression buildPredicate(String nameProduct, TypeEquipmentEnum typeEquipmentEnum,
                                            ColorEquipment colorEquipment,
                                            Integer price, Integer size, Boolean isAvailability, Integer countsDoor,
                                            String typeCompressor, Integer sizeDustCollect, Integer countsRegime,
                                            String typeProcessor,
                                            String category, Integer memoryPhone, Integer countsSnaps, String technology,
                                            Integer offset, Integer limit,
                                            ParametersSort parametersSort, DirectionSort directionSort) {
        QProduct product = QProduct.product;
        BooleanExpression booleanExpression = product.nameProduct.eq(nameProduct);

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
        if (typeEquipmentEnum != null) {
            if (countsDoor != null) {
                if (typeEquipmentEnum.equals(TypeEquipmentEnum.FRIDGE))
                    booleanExpression = booleanExpression.and(product.attributes.countsDoor.eq(countsDoor));
            }
            if (typeCompressor != null) {
                if (typeEquipmentEnum.equals(TypeEquipmentEnum.FRIDGE))
                    booleanExpression = booleanExpression.and(product.attributes.typeCompressor.eq(typeCompressor));
            }
        }
    }

}
