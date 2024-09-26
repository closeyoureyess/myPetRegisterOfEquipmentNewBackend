package com.petregisterofequipmentnew.entities.repositories;

import com.petregisterofequipmentnew.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public class CustomProduct implements CustomProductRepository{
    @Override
    public Page<Product> findAllWithCustomSpec(Specification<Product> spec, Pageable pageable) {
        return null;
    }
}
