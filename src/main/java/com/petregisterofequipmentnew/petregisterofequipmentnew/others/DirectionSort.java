package com.petregisterofequipmentnew.petregisterofequipmentnew.others;

public enum DirectionSort {

    asc("asc"),

    desc("desc");

    private String direction;

    DirectionSort(String direction) {
        this.direction = direction;
    }

    public String getDirection() {
        return direction;
    }
}
