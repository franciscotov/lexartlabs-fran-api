package com.lexartlabs.fran.api.mapper;

import com.lexartlabs.fran.api.dto.ProductVariantDTO;
import com.lexartlabs.fran.api.entities.Product;
import com.lexartlabs.fran.api.entities.ProductVariant;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

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
        dto.setAvailableStock(variant.getAvailableStock());
        return dto;
    }

    public static List<ProductVariant> toUpdateVariantEntityList(List<ProductVariantDTO> dtoList, List<ProductVariant> variantList) {
        int maxUpdateNumber = dtoList.size();
        int updatedCount = 0;
        // map variantList by id for easy lookup and update according to dtoList
        for (ProductVariantDTO dto : dtoList) {
            for (ProductVariant vl : variantList) {
                if (Optional.ofNullable(dto.getId()).isPresent() && dto.getId().equals(vl.getId())) {
                    vl.setPrice(dto.getPrice());
                    vl.setColor(dto.getColor());
                    vl.setAvailableStock(dto.getAvailableStock());
                    updatedCount += 1;
                    break;
                }
            }
            if (updatedCount >= maxUpdateNumber) {
                break;
            }
        }
        return variantList;
    }
}
