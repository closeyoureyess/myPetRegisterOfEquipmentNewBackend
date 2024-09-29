package com.petregisterofequipmentnew.mappers;

import com.petregisterofequipmentnew.dtos.AttributesDto;
import com.petregisterofequipmentnew.dtos.ProductDto;
import com.petregisterofequipmentnew.entities.Attributes;
import com.petregisterofequipmentnew.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class ProductMapperImpl implements ProductMapper {

    @Autowired
    private AttributesMapper attributesMapper;

    @Override
    public Product convertDtoToProduct(ProductDto productDto) {
        Product product = new Product();
        if (productDto.getId() != null) {
            product.setId(productDto.getId());
        }
        if (productDto.getNameProduct() != null) {
            product.setNameProduct(productDto.getNameProduct());
        }
        if (productDto.getNameTypeTechnic() != null) {
            product.setNameTypeTechnic(productDto.getNameTypeTechnic());
        }
        if (productDto.getManufacturerCountry() != null) {
            product.setManufacturerCountry(productDto.getManufacturerCountry());
        }
        if (productDto.getManufacturerCompany() != null) {
            product.setManufacturerCompany(productDto.getManufacturerCompany());
        }
        if (productDto.getIsOrderOnline() != null) {
            product.setIsOrderOnline(productDto.getIsOrderOnline());
        }
        if (productDto.getIsPossibilityInstallments() != null) {
            product.setIsPossibilityInstallments(productDto.getIsPossibilityInstallments());
        }
        if (productDto.getAttributesDto() != null) {
            product.setAttributes(attributesMapper.convertDtoToAttributes(productDto.getAttributesDto()));
        }
        return product;
    }

    @Override
    public ProductDto convertProductToDto(Product product) {
        ProductDto productDto = new ProductDto();
        if (product.getId() != null) {
            productDto.setId(product.getId());
        }
        if (product.getNameProduct() != null) {
            productDto.setNameProduct(product.getNameProduct());
        }
        if (product.getNameTypeTechnic() != null) {
            productDto.setNameTypeTechnic(product.getNameTypeTechnic());
        }
        if (product.getManufacturerCountry() != null) {
            productDto.setManufacturerCountry(product.getManufacturerCountry());
        }
        if (product.getManufacturerCompany() != null) {
            productDto.setManufacturerCompany(product.getManufacturerCompany());
        }
        if (product.getIsOrderOnline() != null) {
            productDto.setIsOrderOnline(product.getIsOrderOnline());
        }
        if (product.getIsPossibilityInstallments() != null) {
            productDto.setIsPossibilityInstallments(product.getIsPossibilityInstallments());
        }
        if (product.getAttributes() != null) {
            productDto.setAttributesDto(attributesMapper.convertAttributesToDto(product.getAttributes()));
        }
        return productDto;
    }

    @Override
    public List<Product> transferProductDtoListToProduct(List<ProductDto> productDtoList) {
        List<Product> productList = new LinkedList<>();
        for (ProductDto productDto : productDtoList) {
            productList.add(new Product(productDto.getId(), productDto.getNameProduct(), productDto.getNameTypeTechnic(), productDto.getManufacturerCountry(),
                    productDto.getManufacturerCompany(), productDto.getIsOrderOnline(), productDto.getIsPossibilityInstallments(), new Attributes(
                    productDto.getAttributesDto().getId(), productDto.getAttributesDto().getNameDevice(),
                    productDto.getAttributesDto().getSerialNumber(), productDto.getAttributesDto().getColor(), productDto.getAttributesDto().getSize(),
                    productDto.getAttributesDto().getPrice(), productDto.getAttributesDto().getIsAvailabilityProducts(), null,
                    productDto.getAttributesDto().getCountsDoor(), productDto.getAttributesDto().getTypeCompressor(),
                    productDto.getAttributesDto().getSizeDustCollect(), productDto.getAttributesDto().getCountsRegime(),
                    productDto.getAttributesDto().getTypeProcessor(), productDto.getAttributesDto().getCategory(),
                    productDto.getAttributesDto().getMemoryPhone(), productDto.getAttributesDto().getCountsSnaps(),
                    productDto.getAttributesDto().getTechnology(), productDto.getAttributesDto().getServiceFlag()
            )));
        }
        return productList;
    }

    @Override
    public List<ProductDto> transferProductListToProductDto(List<Product> productList) {
        List<ProductDto> productDtoList = new LinkedList<>();
        for (Product product : productList) {
            productDtoList.add(new ProductDto(product.getId(), product.getNameProduct(), product.getNameTypeTechnic(), product.getManufacturerCountry(),
                    product.getManufacturerCompany(), product.getIsOrderOnline(), product.getIsOrderOnline(),
                    new AttributesDto(product.getAttributes().getId(), product.getAttributes().getNameDevice(),
                            product.getAttributes().getSerialNumber(), product.getAttributes().getColor(), product.getAttributes().getSize(),
                            product.getAttributes().getPrice(), product.getAttributes().getIsAvailabilityProducts(), null,
                            product.getAttributes().getCountsDoor(), product.getAttributes().getTypeCompressor(),
                            product.getAttributes().getSizeDustCollect(), product.getAttributes().getCountsRegime(),
                            product.getAttributes().getTypeProcessor(), product.getAttributes().getCategory(),
                            product.getAttributes().getMemoryPhone(), product.getAttributes().getCountsSnaps(),
                            product.getAttributes().getTechnology(), product.getAttributes().getServiceFlag())));
        }
        return productDtoList;
    }
}
