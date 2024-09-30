package com.petregisterofequipmentnew.back.others;

public enum TypeEquipmentEnum {

    FRIDGE("FRIDGE"),
    HOOVER("HOOVER"),
    PERSONAL_COMPUTER("PERSONALCOMPUTER"),
    SMARTPHONE("SMARTPHONE"),
    TELEVISION("TELEVISION");

    private String typeEquipmentEnum;

    TypeEquipmentEnum(String typeEquipmentEnum) {
        this.typeEquipmentEnum = typeEquipmentEnum;
    }

    public String getTypeEquipmentEnum() {
        return typeEquipmentEnum;
    }
}