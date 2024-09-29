package com.petregisterofequipmentnew.entities.repositories;

import com.petregisterofequipmentnew.others.ColorEquipment;
import com.petregisterofequipmentnew.others.TypeEquipmentEnum;
import com.petregisterofequipmentnew.entities.QProduct;
import com.querydsl.core.types.Predicate;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
public interface ProductPredicate {

    Predicate buildPredicate(String nameProduct, TypeEquipmentEnum typeEquipmentEnum,
                             ColorEquipment colorEquipment,
                             Integer price, Integer size, Boolean isAvailability, Integer countsDoor,
                             String typeCompressor, Integer sizeDustCollect, Integer countsRegime,
                             String typeProcessor,
                             String category, Integer memoryPhone, Integer countsSnaps, String technology);

    public <T> T individualAttributesProducts(@NotNull T booleanExpression, @NotNull TypeEquipmentEnum typeEquipmentEnum,
                                              QProduct product, Integer countsDoor, String typeCompressor, Integer sizeDustCollect,
                                              Integer countsRegime, String typeProcessor, String category, Integer memoryPhone,
                                              Integer countsSnaps, String technology);
}
