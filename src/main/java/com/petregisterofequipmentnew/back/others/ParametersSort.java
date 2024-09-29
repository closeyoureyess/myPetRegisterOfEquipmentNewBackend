package com.petregisterofequipmentnew.back.others;

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
