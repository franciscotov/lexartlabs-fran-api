package com.lexartlabs.fran.api.exceptions;

public class ProductNotFoundException extends RuntimeException {
    private final Long id;

    public ProductNotFoundException(Long id) {
        super("not_found_product");
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}