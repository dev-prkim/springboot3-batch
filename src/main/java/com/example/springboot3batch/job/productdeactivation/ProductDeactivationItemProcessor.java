package com.example.springboot3batch.job.productdeactivation;

import com.example.springboot3batch.model.Product;
import com.example.springboot3batch.repository.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProductDeactivationItemProcessor implements ItemProcessor<Product, Product> {

  private final ProductRepository productRepository;

  @Override
  public Product process(Product product) throws Exception {
    log.info("[Product Deactivation] Task-2. ItemProcessor productIdx: {}", product.getIdx());
    return processProductDeactivation(product);
  }

  private Product processProductDeactivation(Product product) throws Exception {

    try {
      product = deactivateProduct(product);
      return product;
    } catch (Exception e) {
      log.error("Error occurred while during product deactivation.", e);
      throw new Exception("Error occurred while during product deactivation.", e);
    }
  }

  private Product deactivateProduct(Product product) {
    product.deactivateProduct();
    product = productRepository.save(product);
    return product;
  }

}
