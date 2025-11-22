package com.lexartlabs.fran.api.service.implementation;

import com.lexartlabs.fran.api.dto.ProductDTO;
import com.lexartlabs.fran.api.entities.Product;
import com.lexartlabs.fran.api.exceptions.ProductNotFoundException;
import com.lexartlabs.fran.api.mapper.ProductMapper;
import com.lexartlabs.fran.api.repository.ProductRepository;
import com.lexartlabs.fran.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository repository;

    @Autowired
    ProductMapper mapper;

    @Override
    public ProductDTO getProductById(Long id) {
        var product = repository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
        return mapper.toDTO(product);
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDto) {
        try {
            Product product = mapper.toEntity(productDto);
            Product saved = repository.save(product);
            return mapper.toDTO(saved);
        } catch (Exception e) {
            throw new ProductNotFoundException(1L);
        }
    }

    @Override
    @Transactional
    public ProductDTO updateProduct(Long id, ProductDTO productDto) {
        var actualProduct = repository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
        return mapper.toDTO(repository.save(mapper.toUpdateEntity(productDto, actualProduct)));
    }

    @Override
    @Transactional
    public void deleteProduct(Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new ProductNotFoundException(id);
        }
    }

    @Override
    public Page<ProductDTO> getProducts(Pageable pageable) {
        try {
            Page<Product> products =  repository.findAll(pageable);
            List<ProductDTO> productsDTO = mapper.toDTOList(products.stream().toList());
            return new PageImpl<>(productsDTO, pageable, products.getTotalElements());
        } catch (Exception e) {
            throw new ProductNotFoundException(1L);
        }
    }
}
