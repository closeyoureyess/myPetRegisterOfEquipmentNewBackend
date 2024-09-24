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

    List<Attributes> findAllByNameTypeTechnic(TypeEquipmentEnum nameTypeTechnic, Pageable pageable);

    Page<Attributes> findAllByColor(ColorEquipment colorEquipment, Pageable pageable);

    Page<Attributes> findAllByPriceOrderByPriceAsc(Integer price, Pageable pageable);



}
