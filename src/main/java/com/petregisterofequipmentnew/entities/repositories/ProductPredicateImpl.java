package com.petregisterofequipmentnew.entities.repositories;

import com.petregisterofequipmentnew.others.ColorEquipment;
import com.petregisterofequipmentnew.others.TypeEquipmentEnum;
import com.petregisterofequipmentnew.entities.QProduct;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.stereotype.Component;

@Component
public class ProductPredicateImpl implements ProductPredicate {

    @Override
    public Predicate buildPredicate(String nameProduct, TypeEquipmentEnum typeEquipmentEnum,
                                    ColorEquipment colorEquipment,
                                    Integer price, Integer size, Boolean isAvailability, Integer countsDoor,
                                    String typeCompressor, Integer sizeDustCollect, Integer countsRegime,
                                    String typeProcessor,
                                    String category, Integer memoryPhone, Integer countsSnaps, String technology) {
        QProduct product = QProduct.product;
        BooleanExpression booleanExpression = product.nameProduct.eq(nameProduct);

        booleanExpression = commonCharacteristicsProduct(booleanExpression, product, typeEquipmentEnum, colorEquipment, price, size, isAvailability);
        if (typeEquipmentEnum != null) {
            booleanExpression = individualAttributesProducts(booleanExpression, typeEquipmentEnum, product, countsDoor, typeCompressor, sizeDustCollect,
                    countsRegime, typeProcessor, category, memoryPhone, countsSnaps, technology);
        }
        return booleanExpression;
    }

    private BooleanExpression commonCharacteristicsProduct(BooleanExpression booleanExpression, QProduct product,
                                                           TypeEquipmentEnum typeEquipmentEnum, ColorEquipment colorEquipment,
                                                           Integer price, Integer size, Boolean isAvailability) {
        if (typeEquipmentEnum != null) {
            booleanExpression = booleanExpression.and(product.nameTypeTechnic.eq(typeEquipmentEnum));
        }
        if (colorEquipment != null) {
            booleanExpression = booleanExpression.and(product.attributes.color.eq(colorEquipment));
        }
        if (price != null) {
            booleanExpression = booleanExpression.and(product.attributes.price.eq(price));
        }
        if (size != null) {
            booleanExpression = booleanExpression.and(product.attributes.size.eq(size));
        }
        if (isAvailability != null) {
            booleanExpression = booleanExpression.and(product.attributes.isAvailabilityProducts.eq(isAvailability));
        }
        return booleanExpression;
    }

    @Override
    public <T> T individualAttributesProducts(T booleanExpression, TypeEquipmentEnum typeEquipmentEnum,
                            QProduct product, Integer countsDoor, String typeCompressor, Integer sizeDustCollect,
                            Integer countsRegime, String typeProcessor, String category, Integer memoryPhone,
                            Integer countsSnaps, String technology) {
        int counter = 0;
        switch (typeEquipmentEnum) {
            case FRIDGE -> {
                return buildIndividualAttributesCountsDoor(booleanExpression, product, countsDoor, typeCompressor, counter);
            }
            case HOOVER -> {
                return buildIndividualAttributesHoover(booleanExpression, product, sizeDustCollect, countsRegime, counter);
            }
            case PERSONAL_COMPUTER -> {
                return buildIndividualAttributesPersonalComputer(booleanExpression, product, typeProcessor, category, counter);
            }
            case SMARTPHONE -> {
                return buildIndividualAttributesSmartPhone(booleanExpression, product, memoryPhone, countsSnaps, counter);
            }
            case TELEVISION -> {
                return buildIndividualAttributesTelevision(booleanExpression, product, category, technology, counter);
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    private <T> T buildIndividualAttributesCountsDoor(T booleanExpression, QProduct product, Integer countsDoor,
                                                      String typeCompressor, int counter) {
        if (countsDoor != null) {
            if (booleanExpression instanceof BooleanExpression) {
                booleanExpression = (T) ((BooleanExpression) booleanExpression).and(product.attributes.countsDoor.eq(countsDoor));
            } else if (booleanExpression instanceof Integer) {
                booleanExpression = (T) (Integer) counter++;
            }
        }
        if (typeCompressor != null) {
            if (booleanExpression instanceof BooleanExpression) {
                booleanExpression = (T) ((BooleanExpression) booleanExpression).and(product.attributes.typeCompressor.eq(typeCompressor));
            } else if (booleanExpression instanceof Integer) {
                booleanExpression = (T) (Integer) counter++;
            }
        }
        return booleanExpression;
    }

    @SuppressWarnings("unchecked")
    private <T> T buildIndividualAttributesHoover(T booleanExpression, QProduct product, Integer sizeDustCollect, Integer countsRegime, int counter) {
        if (sizeDustCollect != null) {
            if (booleanExpression instanceof BooleanExpression) {
                booleanExpression = (T) ((BooleanExpression) booleanExpression).and(product.attributes.sizeDustCollect.eq(sizeDustCollect));
            } else if (booleanExpression instanceof Integer) {
                booleanExpression = (T) (Integer) counter++;
            }
        }
        if (countsRegime != null) {
            if (booleanExpression instanceof BooleanExpression) {
                booleanExpression = (T) ((BooleanExpression) booleanExpression).and(product.attributes.countsRegime.eq(countsRegime));
            } else if (booleanExpression instanceof Integer) {
                booleanExpression = (T) (Integer) counter++;
            }
        }
        return booleanExpression;
    }

    @SuppressWarnings("unchecked")
    private <T> T buildIndividualAttributesPersonalComputer(T booleanExpression, QProduct product, String typeProcessor, String category, int counter) {
        if (typeProcessor != null) {
            if (booleanExpression instanceof BooleanExpression) {
                booleanExpression = (T) ((BooleanExpression) booleanExpression).and(product.attributes.typeCompressor.eq(typeProcessor));
            } else if (booleanExpression instanceof Integer) {
                booleanExpression = (T) (Integer) counter++;
            }
        }
        if (category != null) {
            if (booleanExpression instanceof BooleanExpression) {
                booleanExpression = (T) ((BooleanExpression) booleanExpression).and(product.attributes.category.eq(category));
            }
            else if (booleanExpression instanceof Integer) {
                booleanExpression = (T) (Integer) counter++;
            }
        }
        return booleanExpression;
    }

    @SuppressWarnings("unchecked")
    private <T> T buildIndividualAttributesSmartPhone(T booleanExpression, QProduct product, Integer memoryPhone,
                                                      Integer countsSnaps, int counter) {
        if (memoryPhone != null) {
            if (booleanExpression instanceof BooleanExpression) {
                booleanExpression = (T) ((BooleanExpression) booleanExpression).and(product.attributes.memoryPhone.eq(memoryPhone));
            } else if (booleanExpression instanceof Integer) {
                booleanExpression = (T) (Integer) counter++;
            }
        }
        if (countsSnaps != null) {
            if (booleanExpression instanceof BooleanExpression) {
                booleanExpression = (T) ((BooleanExpression) booleanExpression).and(product.attributes.countsRegime.eq(countsSnaps));
            } else if (booleanExpression instanceof Integer) {
                booleanExpression = (T) (Integer) counter++;
            }
        }
        return booleanExpression;
    }

    @SuppressWarnings("unchecked")
    private <T> T buildIndividualAttributesTelevision(T booleanExpression, QProduct product, String category, String technology, int counter) {
        if (category != null) {
            if (booleanExpression instanceof BooleanExpression) {
                booleanExpression = (T) ((BooleanExpression) booleanExpression).and(product.attributes.category.eq(category));
            } else if (booleanExpression instanceof Integer) {
                booleanExpression = (T) (Integer) counter++;
            }
        }
        if (technology != null) {
            if (booleanExpression instanceof BooleanExpression) {
                booleanExpression = (T) ((BooleanExpression) booleanExpression).and(product.attributes.technology.eq(technology));
            } else if (booleanExpression instanceof Integer) {
                booleanExpression = (T) (Integer) counter++;
            }
        }
        return booleanExpression;
    }

}
