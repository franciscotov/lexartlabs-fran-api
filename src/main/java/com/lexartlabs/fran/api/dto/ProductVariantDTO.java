package com.lexartlabs.fran.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lexartlabs.fran.api.shared.constants.FieldLengths;
import com.lexartlabs.fran.api.shared.constants.Messages;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public class ProductVariantDTO {

    private Long id;

    @JsonProperty(value = "price", required = true)
    @NotNull(message = Messages.VARIANT_PRICE_REQUIRED)
    private BigDecimal price;

    @JsonProperty(value = "color", required = true)
    @Size(max = FieldLengths.VARIANT_COLOR_LENGTH, message = Messages.MAX_VARIANT_COLOR_LENGTH_EXCEEDED)
    @NotEmpty(message = Messages.VARIANT_COLOR_REQUIRED)
    private String color;

    @JsonProperty(value = "available_stock", required = true)
    @NotNull(message = Messages.VARIANT_STOCK_REQUIRED)
    private Integer availableStock;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getAvailableStock() {
        return availableStock;
    }

    public void setAvailableStock(Integer availableStock) {
        this.availableStock = availableStock;
    }
}
