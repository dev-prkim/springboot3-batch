package com.example.springboot3batch.job.productactivation;

import com.example.springboot3batch.model.Product;
import com.example.springboot3batch.repository.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProductActivationItemProcessor implements ItemProcessor<Product, Product> {

  private final ProductRepository productRepository;

  @Override
  public Product process(Product product) throws Exception {
    log.info("[Product Activation] Task-2. ItemProcessor productIdx: {}", product.getIdx());
    return processProductActivation(product);
  }

  private Product processProductActivation(Product product) throws Exception {

    try {
      product = activateProduct(product);
      return product;
    } catch (Exception e) {
      log.error("Error occurred while during product activation.", e);
      throw new Exception("Error occurred while during product activation.", e);
    }
  }

  private Product activateProduct(Product product) {
    product.activateProduct();
    product = productRepository.save(product);
    return product;
  }

}
