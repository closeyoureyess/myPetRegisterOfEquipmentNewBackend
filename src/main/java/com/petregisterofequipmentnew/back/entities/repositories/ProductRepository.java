package com.petregisterofequipmentnew.back.entities.repositories;

import com.petregisterofequipmentnew.back.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
 * Нужен рефактор на Criteria API, чтобы строить динамические запросы
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, QuerydslPredicateExecutor<Product> {
    /*Page<Product> findAllByNameProduct(String name, Pageable pageable); // Поиск по имени

    // 6. typeEquipmentEnum, colorEquipment
    @Query(value = "SELECT * FROM Products p INNER JOIN AttributesProducts a ON p.attributes_id = a.id " +
            "WHERE p.name_product = :name AND p.name_type_technic = :typeEquipmentEnum AND a.color = :colorEquipment",
            nativeQuery = true)
    Page<Product> findAllByNameAndTypeTechnicAndColor(String name, TypeEquipmentEnum typeEquipmentEnum, ColorEquipment colorEquipment, Pageable pageable);

    // 7. typeEquipmentEnum, price
    @Query(value = "SELECT * FROM Products p INNER JOIN AttributesProducts a ON p.attributes_id = a.id " +
            "WHERE p.name_product = :name AND p.name_type_technic = :typeEquipmentEnum AND a.price = :price",
            nativeQuery = true)
    Page<Product> findAllByNameAndTypeTechnicAndPrice(String name, TypeEquipmentEnum typeEquipmentEnum, Integer price, Pageable pageable);

    // 8. typeEquipmentEnum, size
    @Query(value = "SELECT * FROM Products p INNER JOIN AttributesProducts a ON p.attributes_id = a.id " +
            "WHERE p.name_product = :name AND p.name_type_technic = :typeEquipmentEnum AND a.size = :size",
            nativeQuery = true)
    Page<Product> findAllByNameAndTypeTechnicAndSize(String name, TypeEquipmentEnum typeEquipmentEnum, Integer size, Pageable pageable);

    // 9. typeEquipmentEnum, isAvailability
    @Query(value = "SELECT * FROM Products p INNER JOIN AttributesProducts a ON p.attributes_id = a.id " +
            "WHERE p.name_product = :name AND p.name_type_technic = :typeEquipmentEnum AND a.availability_model = :isAvailability",
            nativeQuery = true)
    Page<Product> findAllByNameAndTypeTechnicAndAvailability(String name, TypeEquipmentEnum typeEquipmentEnum, Boolean isAvailability, Pageable pageable);

    // 10. colorEquipment, price
    @Query(value = "SELECT * FROM Products p INNER JOIN AttributesProducts a ON p.attributes_id = a.id " +
            "WHERE p.name_product = :name AND a.color = :colorEquipment AND a.price = :price",
            nativeQuery = true)
    Page<Product> findAllByNameAndColorAndPrice(String name, ColorEquipment colorEquipment, Integer price, Pageable pageable);

    // 11. colorEquipment, size
    @Query(value = "SELECT * FROM Products p INNER JOIN AttributesProducts a ON p.attributes_id = a.id " +
            "WHERE p.name_product = :name AND a.color = :colorEquipment AND a.size = :size",
            nativeQuery = true)
    Page<Product> findAllByNameAndColorAndSize(String name, ColorEquipment colorEquipment, Integer size, Pageable pageable);

    // 12. colorEquipment, isAvailability
    @Query(value = "SELECT * FROM Products p INNER JOIN AttributesProducts a ON p.attributes_id = a.id " +
            "WHERE p.name_product = :name AND a.color = :colorEquipment AND a.availability_model = :isAvailability",
            nativeQuery = true)
    Page<Product> findAllByNameAndColorAndAvailability(String name, ColorEquipment colorEquipment, Boolean isAvailability, Pageable pageable);

    // 13. price, size
    @Query(value = "SELECT * FROM Products p INNER JOIN AttributesProducts a ON p.attributes_id = a.id " +
            "WHERE p.name_product = :name AND a.price = :price AND a.size = :size",
            nativeQuery = true)
    Page<Product> findAllByNameAndPriceAndSize(String name, Integer price, Integer size, Pageable pageable);

    // 14. price, isAvailability
    @Query(value = "SELECT * FROM Products p INNER JOIN AttributesProducts a ON p.attributes_id = a.id " +
            "WHERE p.name_product = :name AND a.price = :price AND a.availability_model = :isAvailability",
            nativeQuery = true)
    Page<Product> findAllByNameAndPriceAndAvailability(String name, Integer price, Boolean isAvailability, Pageable pageable);

    // 15. size, isAvailability
    @Query(value = "SELECT * FROM Products p INNER JOIN AttributesProducts a ON p.attributes_id = a.id " +
            "WHERE p.name_product = :name AND a.size = :size AND a.availability_model = :isAvailability",
            nativeQuery = true)
    Page<Product> findAllByNameAndSizeAndAvailability(String name, Integer size, Boolean isAvailability, Pageable pageable);

    // 16. typeEquipmentEnum, colorEquipment, price
    @Query(value = "SELECT * FROM Products p INNER JOIN AttributesProducts a ON p.attributes_id = a.id " +
            "WHERE p.name_product = :name AND p.name_type_technic = :typeEquipmentEnum AND a.color = :colorEquipment AND a.price = :price",
            nativeQuery = true)
    Page<Product> findAllByNameAndTypeTechnicAndColorAndPrice(String name, TypeEquipmentEnum typeEquipmentEnum, ColorEquipment colorEquipment, Integer price, Pageable pageable);

    // 17. typeEquipmentEnum, colorEquipment, size
    @Query(value = "SELECT * FROM Products p INNER JOIN AttributesProducts a ON p.attributes_id = a.id " +
            "WHERE p.name_product = :name AND p.name_type_technic = :typeEquipmentEnum AND a.color = :colorEquipment AND a.size = :size",
            nativeQuery = true)
    Page<Product> findAllByNameAndTypeTechnicAndColorAndSize(String name, TypeEquipmentEnum typeEquipmentEnum, ColorEquipment colorEquipment, Integer size, Pageable pageable);

    // 18. typeEquipmentEnum, colorEquipment, isAvailability
    @Query(value = "SELECT * FROM Products p INNER JOIN AttributesProducts a ON p.attributes_id = a.id " +
            "WHERE p.name_product = :name AND p.name_type_technic = :typeEquipmentEnum AND a.color = :colorEquipment AND a.availability_model = :isAvailability",
            nativeQuery = true)
    Page<Product> findAllByNameAndTypeTechnicAndColorAndAvailability(String name, TypeEquipmentEnum typeEquipmentEnum, ColorEquipment colorEquipment, Boolean isAvailability, Pageable pageable);

    // 19. typeEquipmentEnum, price, size
    @Query(value = "SELECT * FROM Products p INNER JOIN AttributesProducts a ON p.attributes_id = a.id " +
            "WHERE p.name_product = :name AND p.name_type_technic = :typeEquipmentEnum AND a.price = :price AND a.size = :size",
            nativeQuery = true)
    Page<Product> findAllByNameAndTypeTechnicAndPriceAndSize(String name, TypeEquipmentEnum typeEquipmentEnum, Integer price, Integer size, Pageable pageable);

    // 20. typeEquipmentEnum, price, isAvailability
    @Query(value = "SELECT * FROM Products p INNER JOIN AttributesProducts a ON p.attributes_id = a.id " +
            "WHERE p.name_product = :name AND p.name_type_technic = :typeEquipmentEnum AND a.price = :price AND a.availability_model = :isAvailability",
            nativeQuery = true)
    Page<Product> findAllByNameAndTypeTechnicAndPriceAndAvailability(String name, TypeEquipmentEnum typeEquipmentEnum, Integer price, Boolean isAvailability, Pageable pageable);

    // 21. typeEquipmentEnum, size, isAvailability
    @Query(value = "SELECT * FROM Products p INNER JOIN AttributesProducts a ON p.attributes_id = a.id " +
            "WHERE p.name_product = :name AND p.name_type_technic = :typeEquipmentEnum AND a.size = :size AND a.availability_model = :isAvailability",
            nativeQuery = true)
    Page<Product> findAllByNameAndTypeTechnicAndSizeAndAvailability(String name, TypeEquipmentEnum typeEquipmentEnum, Integer size, Boolean isAvailability, Pageable pageable);

    // 22. colorEquipment, price, size
    @Query(value = "SELECT * FROM Products p INNER JOIN AttributesProducts a ON p.attributes_id = a.id " +
            "WHERE p.name_product = :name AND a.color = :colorEquipment AND a.price = :price AND a.size = :size",
            nativeQuery = true)
    Page<Product> findAllByNameAndColorAndPriceAndSize(String name, ColorEquipment colorEquipment, Integer price, Integer size, Pageable pageable);

    // 23. colorEquipment, price, isAvailability
    @Query(value = "SELECT * FROM Products p INNER JOIN AttributesProducts a ON p.attributes_id = a.id " +
            "WHERE p.name_product = :name AND a.color = :colorEquipment AND a.price = :price AND a.availability_model = :isAvailability",
            nativeQuery = true)
    Page<Product> findAllByNameAndColorAndPriceAndAvailability(String name, ColorEquipment colorEquipment, Integer price, Boolean isAvailability, Pageable pageable);

    // 24. colorEquipment, size, isAvailability
    @Query(value = "SELECT * FROM Products p INNER JOIN AttributesProducts a ON p.attributes_id = a.id " +
            "WHERE p.name_product = :name AND a.color = :colorEquipment AND a.size = :size AND a.availability_model = :isAvailability",
            nativeQuery = true)
    Page<Product> findAllByNameAndColorAndSizeAndAvailability(String name, ColorEquipment colorEquipment, Integer size, Boolean isAvailability, Pageable pageable);

    // 25. price, size, isAvailability
    @Query(value = "SELECT * FROM Products p INNER JOIN AttributesProducts a ON p.attributes_id = a.id " +
            "WHERE p.name_product = :name AND a.price = :price AND a.size = :size AND a.availability_model = :isAvailability",
            nativeQuery = true)
    Page<Product> findAllByNameAndPriceAndSizeAndAvailability(String name, Integer price, Integer size, Boolean isAvailability, Pageable pageable);

    // 26. typeEquipmentEnum, colorEquipment, price, size
    @Query(value = "SELECT * FROM Products p INNER JOIN AttributesProducts a ON p.attributes_id = a.id " +
            "WHERE p.name_product = :name AND p.name_type_technic = :typeEquipmentEnum AND a.color = :colorEquipment " +
            "AND a.price = :price AND a.size = :size",
            nativeQuery = true)
    Page<Product> findAllByNameAndTypeTechnicAndColorAndPriceAndSize(String name, TypeEquipmentEnum typeEquipmentEnum, ColorEquipment colorEquipment, Integer price, Integer size, Pageable pageable);

    // 27. typeEquipmentEnum, colorEquipment, price, isAvailability
    @Query(value = "SELECT * FROM Products p INNER JOIN AttributesProducts a ON p.attributes_id = a.id " +
            "WHERE p.name_product = :name AND p.name_type_technic = :typeEquipmentEnum AND a.color = :colorEquipment " +
            "AND a.price = :price AND a.availability_model = :isAvailability",
            nativeQuery = true)
    Page<Product> findAllByNameAndTypeTechnicAndColorAndPriceAndAvailability(String name, TypeEquipmentEnum typeEquipmentEnum, ColorEquipment colorEquipment, Integer price, Boolean isAvailability, Pageable pageable);

    // 28. typeEquipmentEnum, colorEquipment, size, isAvailability
    @Query(value = "SELECT * FROM Products p INNER JOIN AttributesProducts a ON p.attributes_id = a.id " +
            "WHERE p.name_product = :name AND p.name_type_technic = :typeEquipmentEnum AND a.color = :colorEquipment " +
            "AND a.size = :size AND a.availability_model = :isAvailability",
            nativeQuery = true)
    Page<Product> findAllByNameAndTypeTechnicAndColorAndSizeAndAvailability(String name, TypeEquipmentEnum typeEquipmentEnum, ColorEquipment colorEquipment, Integer size, Boolean isAvailability, Pageable pageable);

    // 29. typeEquipmentEnum, price, size, isAvailability
    @Query(value = "SELECT * FROM Products p INNER JOIN AttributesProducts a ON p.attributes_id = a.id " +
            "WHERE p.name_product = :name AND p.name_type_technic = :typeEquipmentEnum " +
            "AND a.price = :price AND a.size = :size AND a.availability_model = :isAvailability",
            nativeQuery = true)
    Page<Product> findAllByNameAndTypeTechnicAndPriceAndSizeAndAvailability(String name, TypeEquipmentEnum typeEquipmentEnum, Integer price, Integer size, Boolean isAvailability, Pageable pageable);

    // 30. colorEquipment, price, size, isAvailability
    @Query(value = "SELECT * FROM Products p INNER JOIN AttributesProducts a ON p.attributes_id = a.id " +
            "WHERE p.name_product = :name AND a.color = :colorEquipment " +
            "AND a.price = :price AND a.size = :size AND a.availability_model = :isAvailability",
            nativeQuery = true)
    Page<Product> findAllByNameAndColorAndPriceAndSizeAndAvailability(String name, ColorEquipment colorEquipment, Integer price, Integer size, Boolean isAvailability, Pageable pageable);

    // 31. typeEquipmentEnum, colorEquipment, price, size, isAvailability
    @Query(value = "SELECT * FROM Products p INNER JOIN AttributesProducts a ON p.attributes_id = a.id " +
            "WHERE p.name_product = :name AND p.name_type_technic = :typeEquipmentEnum AND a.color = :colorEquipment " +
            "AND a.price = :price AND a.size = :size AND a.availability_model = :isAvailability",
            nativeQuery = true)
    Page<Product> findAllByNameAndTypeTechnicAndColorAndPriceAndSizeAndAvailability(String name, TypeEquipmentEnum typeEquipmentEnum, ColorEquipment colorEquipment, Integer price, Integer size, Boolean isAvailability, Pageable pageable);
*/
}
