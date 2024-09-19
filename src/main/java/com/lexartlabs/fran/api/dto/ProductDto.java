package com.lexartlabs.fran.api.dto;

import com.lexartlabs.fran.api.entities.ProductVariant;
import lombok.Data;

import java.util.List;

@Data
public class ProductDto {
    private Long id;

    private String name;
    private String brand;
    private String model;

    private List<ProductVariant> data;
}
