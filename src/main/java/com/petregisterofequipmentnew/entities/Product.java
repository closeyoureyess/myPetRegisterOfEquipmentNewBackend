package com.petregisterofequipmentnew.entities;

import com.petregisterofequipmentnew.others.TypeEquipmentEnum;
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
    private Long id;
    @Column(name = "name_product")
    private String nameProduct;
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
}
