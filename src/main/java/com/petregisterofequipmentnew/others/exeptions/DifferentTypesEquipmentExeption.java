package com.petregisterofequipmentnew.others.exeptions;

public class DifferentTypesEquipmentExeption extends MainException{
    public DifferentTypesEquipmentExeption(String message) {
        super(message);
    }

    public DifferentTypesEquipmentExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public DifferentTypesEquipmentExeption(Throwable cause) {
        super(cause);
    }
}
