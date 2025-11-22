package com.lexartlabs.fran.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lexartlabs.fran.api.shared.constants.FieldLengths;
import com.lexartlabs.fran.api.shared.constants.Messages;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class ProductDTO {
    private Long id;

    @JsonProperty(value = "name", required = true)
    @Size(max = FieldLengths.PRODUCT_NAME_LENGTH, message = Messages.MAX_PRODUCT_NAME_LENGTH_EXCEEDED)
    @NotEmpty(message = Messages.PRODUCT_NAME_REQUIRED)
    private String name;

    @JsonProperty(value="brand", required = true)
    @Size(max = FieldLengths.PRODUCT_BRAND_LENGTH, message = Messages.MAX_PRODUCT_BRAND_LENGTH_EXCEEDED)
    @NotEmpty(message = Messages.PRODUCT_BRAND_REQUIRED)
    private String brand;

    @JsonProperty(value="model", required = true)
    @Size(max = FieldLengths.PRODUCT_MODEL_LENGTH, message = Messages.MAX_PRODUCT_MODEL_LENGTH_EXCEEDED)
    @NotEmpty(message = Messages.PRODUCT_MODEL_REQUIRED)
    private String model;

    @Valid
    @NotEmpty
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
