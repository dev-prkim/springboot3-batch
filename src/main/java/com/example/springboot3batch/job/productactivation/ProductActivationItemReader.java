package com.example.springboot3batch.job.productactivation;

import com.example.springboot3batch.model.Product;
import com.example.springboot3batch.repository.product.ProductRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.stereotype.Component;

@Slf4j
@StepScope
@Component
@RequiredArgsConstructor
public class ProductActivationItemReader implements ItemReader<Product> {

  private final ProductRepository productRepository;

  private ListItemReader<Product> listItemReader;

  @Override
  public Product read() {

    if(listItemReader == null) {
      log.info("[Product Activation] Task-1. ItemReader");

      List<Product> products = productRepository.findProductsStartSale();
      listItemReader = new ListItemReader<>(products);
    }

    return listItemReader.read();
  }
}
