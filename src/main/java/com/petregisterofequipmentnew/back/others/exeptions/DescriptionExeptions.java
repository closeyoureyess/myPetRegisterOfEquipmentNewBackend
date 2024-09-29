package com.petregisterofequipmentnew.back.others.exeptions;

public enum DescriptionExeptions {

    GENERATION_ERROR("Возникла ошибка в системе"),
    FIELDS_NOT_NULL("Переменные не могут быть пусты. Попробуйте еще раз"),
    NAME_TYPE_TECHNIC_NOT_FOUND("попытка создать сущность без заполненного поля имя техники. Проверьте запрос и попробуйте ещё раз"),
    DIFFERENT_TYPES_TECHNICS("в продукте и атрибутах выбраны несовместимые типы. Попробуйте ещё раз"),
    SORT_FIELD_NOT_BE_NULL("поле сортировки не может быть пустым. Попробуйте ещё раз.");

    private String description;

    DescriptionExeptions(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
