package com.petregisterofequipmentnew.petregisterofequipmentnew.others;

public enum ParametersSort {

    alphabet("Alphabet"),
    cost("Price");

    private String parameters;

    ParametersSort(String parameters) {
        this.parameters = parameters;
    }

    public String getParameters() {
        return parameters;
    }
}
