package com.petregisterofequipmentnew.entities;

import com.petregisterofequipmentnew.ColorEquipment;
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
    private Long id;
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
    @Column(name = "availability_model")
    private Boolean isAvailabilityProducts;
    @OneToMany(mappedBy = "attributes")
    private List<Product> productList;

    @Column(name = "numbercount_door")
    private Integer countsDoor;
    @Column(name = "compressor_type")
    private String typeCompressor;
    @Column(name = "size_dust_collect")
    private Integer sizeDustCollect;
    @Column(name = "numbercount_regime")
    private Integer countsRegime;
    @Column(name = "processor_type")
    private String typeProcessor;
    @Column(name = "category")
    private String category;
    @Column(name = "memory")
    private Integer memoryPhone;
    @Column(name = "numbercount_snaps")
    private Integer countsSnaps;
    @Column(name = "technology_tv")
    private String technology;
    @Transient
    private Integer serviceFlag;

}
