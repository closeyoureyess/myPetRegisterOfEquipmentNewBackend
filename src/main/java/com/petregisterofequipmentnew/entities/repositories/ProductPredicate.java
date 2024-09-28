package com.petregisterofequipmentnew.entities.repositories;

import com.petregisterofequipmentnew.ColorEquipment;
import com.petregisterofequipmentnew.TypeEquipmentEnum;
import com.querydsl.core.types.Predicate;

public interface ProductPredicate {

    Predicate buildPredicate(String nameProduct, TypeEquipmentEnum typeEquipmentEnum,
                             ColorEquipment colorEquipment,
                             Integer price, Integer size, Boolean isAvailability, Integer countsDoor,
                             String typeCompressor, Integer sizeDustCollect, Integer countsRegime,
                             String typeProcessor,
                             String category, Integer memoryPhone, Integer countsSnaps, String technology);


}
