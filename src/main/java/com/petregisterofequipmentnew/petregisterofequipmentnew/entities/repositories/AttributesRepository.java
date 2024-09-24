package com.petregisterofequipmentnew.petregisterofequipmentnew.entities.repositories;

import com.petregisterofequipmentnew.petregisterofequipmentnew.entities.Attributes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributesRepository extends JpaRepository<Attributes, Long> {



}
