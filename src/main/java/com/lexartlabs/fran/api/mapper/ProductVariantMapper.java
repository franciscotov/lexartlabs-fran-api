package com.lexartlabs.fran.api.mapper;

import com.lexartlabs.fran.api.dto.ProductVariantDTO;
import com.lexartlabs.fran.api.entities.Product;
import com.lexartlabs.fran.api.entities.ProductVariant;
import org.springframework.stereotype.Component;

@Component
public class ProductVariantMapper {

    public static ProductVariant toVariantEntity(ProductVariantDTO dto, Product product) {
        ProductVariant variant = new ProductVariant(dto.getPrice(), dto.getColor(), dto.getAvailableStock());
        variant.setProduct(product);
        return variant;
    }

    public static ProductVariantDTO toVariantDTO(ProductVariant variant) {
        ProductVariantDTO dto = new ProductVariantDTO();
        dto.setId(variant.getId());
        dto.setPrice(variant.getPrice());
        dto.setColor(variant.getColor());
        dto.setAvailableStock(variant.getAvailableStock().longValue());
        return dto;
    }
}
