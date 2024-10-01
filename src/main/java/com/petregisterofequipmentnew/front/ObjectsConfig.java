package com.petregisterofequipmentnew.front;

import com.petregisterofequipmentnew.back.dtos.ProductDto;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObjectsConfig {

    @Bean
    public Button builderObject(){
        return new Button();
    }

    @Bean
    public Grid<ProductDto> buildGridProductDto() {
        return new Grid<>(ProductDto.class);
    }
    
}