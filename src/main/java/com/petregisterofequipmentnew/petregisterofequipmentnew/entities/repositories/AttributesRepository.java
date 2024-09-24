package com.petregisterofequipmentnew.petregisterofequipmentnew.entities.repositories;

import com.petregisterofequipmentnew.petregisterofequipmentnew.ColorEquipment;
import com.petregisterofequipmentnew.petregisterofequipmentnew.TypeEquipmentEnum;
import com.petregisterofequipmentnew.petregisterofequipmentnew.entities.Attributes;
import com.petregisterofequipmentnew.petregisterofequipmentnew.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttributesRepository extends JpaRepository<Attributes, Long> {

    Page<Attributes> findAllByIdAndColor(Long id, ColorEquipment colorEquipment, Pageable pageable);
    // id + color - (name + type) -> id + color
    Page<Attributes> findAllByIdAndPriceOrderByPriceAsc(Long id, Integer price, Pageable pageable);
    //nameProduct -> id + price
    Page<Attributes> findAllByIdAndPriceOrderByPriceDesc(Long id, Integer price, Pageable pageable);


}
