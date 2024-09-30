package com.petregisterofequipmentnew.front;

import com.petregisterofequipmentnew.back.dtos.AttributesDto;
import com.petregisterofequipmentnew.back.dtos.ProductDto;
import com.petregisterofequipmentnew.back.entities.Product;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import static com.petregisterofequipmentnew.back.others.ConstantsClass.*;
import static com.petregisterofequipmentnew.back.others.TypeEquipmentEnum.FRIDGE;

@Route
public class ModelView extends VerticalLayout {

    public ModelView() {
        ProductDto productDto = ProductDto.builder().id(Long.valueOf(ONE_FLAG)).nameProduct(TEST_VALUE_STRING).nameTypeTechnic(FRIDGE)
                .manufacturerCountry(TEST_VALUE_STRING).manufacturerCompany(TEST_VALUE_STRING)
                .isOrderOnline(TEST_VALUE_BOOLEAN).isPossibilityInstallments(TEST_VALUE_BOOLEAN)
                .attributesDto(new AttributesDto(Long.valueOf(ONE_FLAG), null, null,
                        null, null, null, null, null,
                        null, null, null, null,
                        null, null, null, null, null,
                        null)).build();
        Grid<ProductDto> productDtoGrid = getFieldsNameFromCustomClass(productDto, new Grid<>());

    }

    private Grid<ProductDto> getFieldsNameFromCustomClass(ProductDto productDto, Grid<ProductDto> productGrid) {
        List<Field> fieldList = Arrays.stream(productDto.getClass().getDeclaredFields()).toList();
        for (Field field : fieldList) {
            String newField = field.getName();
            productGrid.addColumns(newField);
            if (newField.equals(ATTRIBUTESDTO_FIELD_NAME)) {
                newField = newField.substring(ZERO_FLAG, newField.lastIndexOf(D_ALPHABET_SYMBOL) + 1);
            }
            productGrid.addColumns(newField);
        }
        return productGrid;
    }

}
