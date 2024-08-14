package com.vinteg.vinteg_app.controller;

import com.vinteg.vinteg_app.model.Product;
import com.vinteg.vinteg_app.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @PostMapping(value = "/api/products", consumes = "multipart/form-data")
    public ResponseEntity<Product> createProduct(@RequestParam("title") String title,
                                                 @RequestParam("description") String description,
                                                 @RequestParam("category") String category,
                                                 @RequestParam("brand") String brand,
                                                 @RequestParam("condition") String condition,
                                                 @RequestParam("price") Double price,
                                                 @RequestParam("image") MultipartFile image) throws IOException {
        Product product = new Product();
        product.setTitle(title);
        product.setDescription(description);
        product.setCategory(category);
        product.setBrand(brand);
        product.setCondition(condition);
        product.setPrice(price);
        product.setImage(image.getBytes());

        Product savedProduct = productRepository.save(product);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }
}