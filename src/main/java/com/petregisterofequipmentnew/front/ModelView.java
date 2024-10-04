package com.petregisterofequipmentnew.front;

import com.petregisterofequipmentnew.back.dtos.AttributesDto;
import com.petregisterofequipmentnew.back.dtos.ProductDto;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static com.petregisterofequipmentnew.back.others.ConstantsClass.*;
import static com.petregisterofequipmentnew.back.others.TypeEquipmentEnum.FRIDGE;
import static com.petregisterofequipmentnew.front.ConstantsFront.*;

@Route("app/model")
public class ModelView extends BaseAppLayout {

    public ModelView() {
        Button button = new Button();
        Grid<ProductDto> gridProductDto = new Grid<>(ProductDto.class);
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        VerticalLayout verticalLayout = new VerticalLayout();
        ProductDto productDto = createProductDtoWithBuilder();
        gridProductDto.removeAllColumns();
        List<String> stringList = getFieldsNameFromCustomClass(productDto);
        for (String s : stringList) {
            if (s.equals(ATTRIBUTESDTO_FIELD_NAME)) {
                gridProductDto.addColumn(s).setHeader(NAME_DEVICE_FIELD_NAME);
            } else {
                gridProductDto.addColumn(s);
            }
        }

        button.setText(CREATE_BUTTON);

        horizontalLayout.setWidthFull();
        horizontalLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.END);
        horizontalLayout.getStyle().set(MARGIN_CSS_STYLE, "20px");
        horizontalLayout.add(button);

        verticalLayout.add(horizontalLayout, gridProductDto);

        setContent(verticalLayout);
    }

    private ProductDto createProductDtoWithBuilder() {
        return ProductDto.builder().id(Long.valueOf(ONE_FLAG)).nameProduct(TEST_VALUE_STRING).nameTypeTechnic(FRIDGE)
                .manufacturerCountry(TEST_VALUE_STRING).manufacturerCompany(TEST_VALUE_STRING)
                .isOrderOnline(TEST_VALUE_BOOLEAN).isPossibilityInstallments(TEST_VALUE_BOOLEAN)
                .attributesDto(new AttributesDto(Long.valueOf(ONE_FLAG), null, null,
                        null, null, null, null, null,
                        null, null, null, null,
                        null, null, null, null, null,
                        null)).build();
    }

    private List<String> getFieldsNameFromCustomClass(ProductDto productDto) {
        List<String> stringList = new LinkedList<>();
        List<Field> fieldList = Arrays.stream(productDto.getClass().getDeclaredFields()).toList();
        for (Field field : fieldList) {
            String newField = field.getName();
            stringList.add(newField);
        }
        return stringList;
    }
}
