package com.petregisterofequipmentnew.entities.repositories;

import com.petregisterofequipmentnew.others.ColorEquipment;
import com.petregisterofequipmentnew.entities.Attributes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributesRepository extends JpaRepository<Attributes, Long> {

    Page<Attributes> findAllByIdAndColor(Long id, ColorEquipment colorEquipment, Pageable pageable);
    // id + color - (name + type) -> id + color
    Page<Attributes> findAllByIdAndPriceOrderByPriceAsc(Long id, Integer price, Pageable pageable);
    //nameProduct -> id + price
    Page<Attributes> findAllByIdAndPriceOrderByPriceDesc(Long id, Integer price, Pageable pageable);


}
