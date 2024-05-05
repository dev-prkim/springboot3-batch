package com.example.springboot3batch.domain.model.type.converter;

import com.example.springboot3batch.domain.model.type.UserStatusType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class UserStatusConverter implements AttributeConverter<UserStatusType, String> {

  @Override
  public String convertToDatabaseColumn(UserStatusType attribute) {
    return attribute.getCode();
  }

  @Override
  public UserStatusType convertToEntityAttribute(String dbData) {
    return UserStatusType.ofCode(dbData);
  }
}
