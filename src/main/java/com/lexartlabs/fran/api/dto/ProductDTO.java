package com.lexartlabs.fran.api.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProductDTO {
    private Long id;

    private String name;
    private String brand;
    private String model;

    private List<ProductVariantDTO> data;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<ProductVariantDTO> getData() {
        return data;
    }

    public void setData(List<ProductVariantDTO> data) {
        this.data = data;
    }
}
