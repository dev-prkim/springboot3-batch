package com.example.springboot3batch.domain.model;

import com.example.springboot3batch.domain.model.type.ProductStatusType;
import com.example.springboot3batch.domain.model.type.converter.ProductStatusConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idx;

  @Column(nullable = false, unique = true)
  private String code;

  @Column(nullable = false)
  private String name;

  @Convert(converter = ProductStatusConverter.class)
  @Column(nullable = false)
  private ProductStatusType status;

  @Comment("판매 시작일시")
  private LocalDateTime saleStartAt;

  @Comment("판매 종료일시")
  private LocalDateTime saleEndAt;

  private Integer amount;

}
