package com.example.springboot3batch.repository.product;

import com.example.springboot3batch.model.Product;
import com.example.springboot3batch.model.QProduct;
import com.example.springboot3batch.model.type.ProductStatusType;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements QProductRepository {

  private final JPAQueryFactory query;

  QProduct product = QProduct.product;

  @Override
  public List<Product> findProductsStartSale() {
    return query
        .selectFrom(product)
        .where(
            eqStatus(ProductStatusType.SALE_PENDING),
            isSaleStartAtPassed()
        )
        .fetch();
  }

  @Override
  public List<Product> findProductsEndSale() {
    return query
        .selectFrom(product)
        .where(
            eqStatus(ProductStatusType.ON_SALE),
            isSaleEndAtPassed()
        )
        .fetch();
  }

  private BooleanExpression eqStatus(ProductStatusType status) {
    return product.status.eq(status);
  }

  private BooleanExpression isSaleStartAtPassed() {
    return product.saleStartAt.before(LocalDateTime.now());
  }

  private BooleanExpression isSaleEndAtPassed() {
    return product.saleEndAt.before(LocalDateTime.now());
  }
}
