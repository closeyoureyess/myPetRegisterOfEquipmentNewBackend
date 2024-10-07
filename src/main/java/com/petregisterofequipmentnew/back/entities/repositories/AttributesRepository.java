package com.petregisterofequipmentnew.back.entities.repositories;

import com.petregisterofequipmentnew.back.others.ColorEquipment;
import com.petregisterofequipmentnew.back.entities.Attributes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AttributesRepository extends JpaRepository<Attributes, Long> {

    Page<Attributes> findAllByNameDevice(String nameDevice, Pageable pageable);
    Optional<Long> countByNameDeviceContainingIgnoreCase(String nameDevice);
    Page<Attributes> findAllByIdAndColor(Long id, ColorEquipment colorEquipment, Pageable pageable);
    // id + color - (name + type) -> id + color
    Page<Attributes> findAllByIdAndPriceOrderByPriceAsc(Long id, Integer price, Pageable pageable);
    //nameProduct -> id + price
    Page<Attributes> findAllByIdAndPriceOrderByPriceDesc(Long id, Integer price, Pageable pageable);


}
