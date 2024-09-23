package com.petregisterofequipmentnew.petregisterofequipmentnew.entities;

import com.petregisterofequipmentnew.petregisterofequipmentnew.TypeEquipmentEnum;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Products")
@Getter
@Setter
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name_type_technic")
    @Enumerated(EnumType.STRING)
    private TypeEquipmentEnum nameTypeTechnic;
    @Column(name = "manufacturer_country")
    private String manufacturerCountry;
    @Column(name = "manufacturer_company")
    private String manufacturerCompany;
    @Column(name = "order_online")
    private Boolean isOrderOnline;
    @Column(name = "possibility_installments")
    private Boolean isPossibilityInstallments;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "attributes_id")
    private Attributes attributes;

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
