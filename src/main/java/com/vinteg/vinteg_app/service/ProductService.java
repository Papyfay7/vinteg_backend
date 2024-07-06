package com.vinteg.vinteg_app.service;

import com.vinteg.vinteg_app.model.Product;
import com.vinteg.vinteg_app.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * Crée un nouveau produit dans la base de données.
     * @param product Les détails du produit à créer.
     * @return Le produit créé.
     */
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    /**
     * Récupère tous les produits présents dans la base de données.
     * @return La liste de tous les produits.
     */
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
