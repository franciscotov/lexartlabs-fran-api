package com.lexartlabs.fran.api.repository;

import com.lexartlabs.fran.api.entities.ProductVariant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductVariantRepository extends JpaRepository<ProductVariant, Long> {
}
