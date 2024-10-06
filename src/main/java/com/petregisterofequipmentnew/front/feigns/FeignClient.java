package com.petregisterofequipmentnew.front.feigns;

import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.stereotype.Component;

@Component
public interface FeignClient {

    AttributesFeignClient createAttributesFeignClient();
    ProductFeignClient createProductFeignClient();

}
