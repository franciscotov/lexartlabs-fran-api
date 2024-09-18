package com.lexartlabs.fran.api.repository;

import com.lexartlabs.fran.api.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
