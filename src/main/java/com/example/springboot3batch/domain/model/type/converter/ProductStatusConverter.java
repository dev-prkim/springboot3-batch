package com.example.springboot3batch.domain.model.type.converter;

import com.example.springboot3batch.domain.model.type.ProductStatusType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class ProductStatusConverter implements AttributeConverter<ProductStatusType, String> {

  @Override
  public String convertToDatabaseColumn(ProductStatusType attribute) {
    return attribute.getCode();
  }

  @Override
  public ProductStatusType convertToEntityAttribute(String dbData) {
    return ProductStatusType.ofCode(dbData);
  }
}
