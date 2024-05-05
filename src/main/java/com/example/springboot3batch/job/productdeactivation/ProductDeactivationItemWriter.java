package com.example.springboot3batch.job.productdeactivation;

import com.example.springboot3batch.model.Product;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ProductDeactivationItemWriter implements ItemWriter<Product> {

  @Override
  public void write(Chunk<? extends Product> data) {
    Optional.ofNullable(data.getItems())
        .orElseThrow(RuntimeException::new)
        .forEach(this::writeLog);
  }

  private void writeLog(Product product) {
    log.info(String.format("The product has been deactivated. idx: %s\n code: %s\n name:%s",
        product.getIdx(), product.getCode(), product.getName()));
  }


}
