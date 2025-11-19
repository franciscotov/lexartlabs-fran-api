package com.lexartlabs.fran.api.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table()
@Entity(name = "products")
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String brand;
    private String model;

    @OneToMany(mappedBy = "product", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<ProductVariant> data;

    public Product(String name, String brand, String model) {
        this.name = name;
        this.brand = brand;
        this.model = model;
        this.data = data;
    }

    public Product(String name, String brand, String model, List<ProductVariant> data) {
        this.name = name;
        this.brand = brand;
        this.model = model;
        this.data = data;
    }

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

    public List<ProductVariant> getData() {
        return data;
    }

    public void setData(List<ProductVariant> data) {
        this.data = data;
    }
}
