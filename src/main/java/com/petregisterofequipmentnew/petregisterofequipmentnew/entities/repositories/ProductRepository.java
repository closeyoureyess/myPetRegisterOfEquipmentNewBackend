package com.petregisterofequipmentnew.petregisterofequipmentnew.entities.repositories;

import com.petregisterofequipmentnew.petregisterofequipmentnew.ColorEquipment;
import com.petregisterofequipmentnew.petregisterofequipmentnew.TypeEquipmentEnum;
import com.petregisterofequipmentnew.petregisterofequipmentnew.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findAllByNameProduct(String name, Pageable pageable); // Поиск по имени
    Page<Product> findAllByNameAndTypeTechnic(String name, TypeEquipmentEnum nameTypeTechnic, Pageable pageable); // Поиск по типу

}
