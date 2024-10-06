package com.petregisterofequipmentnew.front.productspage;

import com.petregisterofequipmentnew.back.dtos.AttributesDto;
import com.petregisterofequipmentnew.front.feigns.FeignClient;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import static com.petregisterofequipmentnew.back.others.ConstantsClass.TEST_VALUE_BOOLEAN;
import static com.petregisterofequipmentnew.front.ConstantsFront.CHOOSE_ELEMENT;

@SpringComponent
@UIScope
public class CreateProductDialog extends Dialog {

    @Autowired
    private FeignClient feignClient;

    public CreateProductDialog() {

        ComboBox<String> comboBox = createNewCombox();

        Button saveButton = new Button("Сохранить", event -> {
            String selectedValue = comboBox.getValue();
            if (selectedValue != null && !selectedValue.isEmpty()) {
                // Логика сохранения или обработки выбранного значения
                Notification.show("Сохранено значение: " + selectedValue);
            } else {
                Notification.show("Пожалуйста, выберите или введите значение.", 3000, Notification.Position.MIDDLE);
            }
            close(); // Закрыть диалог после сохранения
        });
        add(comboBox, saveButton);
        open();
    }

    private ComboBox<String> createNewCombox() {
        ComboBox<String> comboBox = new ComboBox<>(CHOOSE_ELEMENT);
        comboBox.setAllowCustomValue(TEST_VALUE_BOOLEAN);
        comboBox.setDataProvider((filter, offset, limit) -> {
                    if (filter != null)
                        return filterUserInputInCombox(filter, offset, limit);
                    return null;
                },
                filterText -> {
                    if (filterText != null)
                        return countAttributesByName(filterText);
                    return null;
                }
        );
        comboBox.addValueChangeListener(event -> {
            String currentValue = event.getValue();
            if (currentValue != null) {
                Notification.show("Вы выбрали: " + currentValue);
            }
        });
        return comboBox;
    }

    private Stream<String> filterUserInputInCombox(String queryFilter, Integer offset, Integer limit) {
        List<AttributesDto> attributesDtoList = feignClient.createAttributesFeignClient()
                .findAttributesByName(queryFilter, offset, limit)
                .getBody();
        List<String> attributesList = new LinkedList<>();;
        if (attributesDtoList != null) {
        for (AttributesDto attributesDto : attributesDtoList)
            attributesList.add(attributesDto.getNameDevice());
        }
        return attributesList.stream();
    }

    private int countAttributesByName(String filter) {
        Long newLong = feignClient.createAttributesFeignClient().findCountAttributesByName(filter).getBody();
        return Integer.parseInt(
                String.valueOf(newLong)
        );
    }
}
