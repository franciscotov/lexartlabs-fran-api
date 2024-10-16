package com.lexartlabs.fran.api.service;

import com.lexartlabs.fran.api.dto.ProductDto;
import com.lexartlabs.fran.api.entities.Product;
import com.lexartlabs.fran.api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public void createProduct(ProductDto productDto) {
        Product product = new Product(productDto.getName(), productDto.getBrand(), productDto.getModel());
        repository.save(product);
    }

    public Product updateProduct(Long id, ProductDto productDto) throws Exception {
        Optional<Product> product = repository.findById(id);
        if(product.isPresent()) {
            Product actualProduct = product.get();
            actualProduct.setName(productDto.getName());
            actualProduct.setBrand(productDto.getBrand());
            actualProduct.setModel(productDto.getModel());
            return repository.save(actualProduct);
        }
        throw new Exception("Product not found");
    }

    public void deleteProduct(Long id) {
        repository.deleteById(id);
    }

    public Page<Product> getProducts(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
