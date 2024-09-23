package com.petregisterofequipmentnew.petregisterofequipmentnew.entities;

import com.petregisterofequipmentnew.petregisterofequipmentnew.ColorEquipment;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "AttributesProducts")
@Getter
@Setter
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Attributes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name_device")
    private String nameDevice;
    @Column(name = "serial_number")
    private Integer serialNumber;
    @Column(name = "color")
    @Enumerated(EnumType.STRING)
    private ColorEquipment color;
    @Column(name = "size")
    private Integer size;
    @Column(name = "price")
    private Integer price;
    @Column(name = "category")
    private String category;
    @Column(name = "availability_model")
    private Boolean isAvailabilityProducts;
    @OneToMany(mappedBy = "attributes")
    private List<Product> productList;

}
