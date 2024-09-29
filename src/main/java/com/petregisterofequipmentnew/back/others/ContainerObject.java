package com.petregisterofequipmentnew.back.others;

import lombok.*;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class ContainerObject<T, R> {

    private T objectOne;
    private R objectTwo;

}
