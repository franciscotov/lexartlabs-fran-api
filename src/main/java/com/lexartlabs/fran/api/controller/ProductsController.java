package com.lexartlabs.fran.api.controller;

import com.lexartlabs.fran.api.dto.ProductDTO;
import com.lexartlabs.fran.api.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE,RequestMethod.PATCH})
@RequestMapping("/api/products/")
@SecurityRequirement(name = "bearerAuth")
public class ProductsController {

    @Autowired
    private ProductService service;

    @PostMapping("/")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody @Valid ProductDTO data) {
        return ResponseEntity.ok(service.createProduct(data));
    }

    @GetMapping("/products")
    public ResponseEntity<Page<ProductDTO>> getProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(service.getProducts(PageRequest.of(page, size)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable Long id) {
        return ResponseEntity.ok(service.getProductById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Long id, @RequestBody @Valid ProductDTO data) {
        return ResponseEntity.ok(service.updateProduct(id, data));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
            service.deleteProduct(id);
            return ResponseEntity.ok().build();
    }
}
