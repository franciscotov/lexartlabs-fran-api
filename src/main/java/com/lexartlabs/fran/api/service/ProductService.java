package com.lexartlabs.fran.api.service;

import com.lexartlabs.fran.api.entities.Product;
import com.lexartlabs.fran.api.interfaces.CrudService;
import com.lexartlabs.fran.api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository repository;

    public Product getProductById(Long id) {
        Optional<Product> product = repository.findById(id);
        return product.get();
    }

}
