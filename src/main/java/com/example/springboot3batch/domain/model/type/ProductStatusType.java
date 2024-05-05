package com.example.springboot3batch.domain.model.type;

import java.util.Arrays;
import java.util.NoSuchElementException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ProductStatusType {
  SALE_PENDING("01"),
  ON_SALE("00"),
  SALE_SUSPENDED("11")
  ;

  private final String code;

  public static ProductStatusType ofCode(String code) {
    return Arrays.stream(ProductStatusType.values())
        .filter(v -> v.getCode().equals(code))
        .findAny()
        .orElseThrow(NoSuchElementException::new);
  }


}
