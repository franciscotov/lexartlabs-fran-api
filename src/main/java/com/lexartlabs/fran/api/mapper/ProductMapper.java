package com.lexartlabs.fran.api.mapper;

import com.lexartlabs.fran.api.dto.ProductDTO;
import com.lexartlabs.fran.api.dto.ProductVariantDTO;
import com.lexartlabs.fran.api.entities.Product;
import com.lexartlabs.fran.api.entities.ProductVariant;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductMapper {

    public ProductDTO toDTO(Product product) {
        ProductDTO dto = new ProductDTO();

        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setBrand(product.getBrand());
        dto.setModel(product.getModel());

        List<ProductVariantDTO> variants = product.getData()
                .stream()
                .map(ProductVariantMapper::toVariantDTO)
                .toList();

        dto.setData(variants);

        return dto;
    }

    public Product toEntity(ProductDTO dto) {
        Product product = new Product(dto.getName(), dto.getBrand(), dto.getModel());

        List<ProductVariant> variants = dto.getData()
                .stream()
                .map(v -> ProductVariantMapper.toVariantEntity(v, product))
                .toList();

        product.setData(variants);

        return product;
    }

    public List<ProductDTO> toDTOList (List<Product> products) {
        return products.stream().map(this::toDTO).toList();
    }

    public Product toUpdateEntity(ProductDTO dto, Product product) {
        product.setName(dto.getName());
        product.setBrand(dto.getBrand());
        product.setModel(dto.getModel());
        product.setData(ProductVariantMapper.toUpdateVariantEntityList(dto.getData(), product.getData()));
        return product;
    }
}
