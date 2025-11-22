package com.lexartlabs.fran.api.entities;

import com.lexartlabs.fran.api.shared.constants.FieldLengths;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Table()
@Entity(name = "product-variants")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductVariant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="price", nullable = false, precision = FieldLengths.VARIANT_PRICE_PRECISION, scale = FieldLengths.VARIANT_PRICE_SCALE)
    private BigDecimal price;

    @Column(name="color", nullable = false, length = FieldLengths.VARIANT_COLOR_LENGTH)
    private String color;

    @Column(name="available_stock", nullable = false)
    private Integer availableStock;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public ProductVariant(BigDecimal price, String color, Integer availableStock) {
        this.price = price;
        this.color = color;
        this.availableStock = availableStock;
    }

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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getAvailableStock() {
        return availableStock;
    }

    public void setAvailableStock(Integer availableStock) {
        this.availableStock = availableStock;
    }
}
