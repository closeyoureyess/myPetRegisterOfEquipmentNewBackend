package com.petregisterofequipmentnew.petregisterofequipmentnew.entities.repositories;

import com.petregisterofequipmentnew.petregisterofequipmentnew.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface CustomProductRepository {

    Page<Product> findAllWithCustomSpec(Specification<Product> spec, Pageable pageable);

}
