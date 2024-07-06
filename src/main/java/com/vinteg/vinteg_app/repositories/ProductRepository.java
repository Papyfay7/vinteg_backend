package com.vinteg.vinteg_app.repositories;

import com.vinteg.vinteg_app.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO products (`condition`, description, price, title) VALUES (:condition, :description, :price, :title)", nativeQuery = true)
    void insertProduct(@Param("condition") String condition, @Param("description") String description, @Param("price") double price, @Param("title") String title);
}
