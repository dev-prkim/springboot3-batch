package com.example.springboot3batch.repository.product;

import com.example.springboot3batch.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>, QProductRepository {

}
