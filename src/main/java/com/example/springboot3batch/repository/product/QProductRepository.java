package com.example.springboot3batch.repository.product;

import com.example.springboot3batch.model.Product;
import java.util.List;

public interface QProductRepository {

  List<Product> findProductsStartSale();

  List<Product> findProductsEndSale();

}
