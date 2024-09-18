package com.lexartlabs.fran.api.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table()
@Entity(name = "product-variants")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductVariant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer price;
    private String color;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public ProductVariant(Integer price, String color) {
        this.price = price;
        this.color = color;
    }
}
