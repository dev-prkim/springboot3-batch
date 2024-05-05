package com.example.springboot3batch.model.type;

import java.util.Arrays;
import java.util.NoSuchElementException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserStatusType {
  ACTIVE("00"),
  WITHDRAWAL_PENDING("10"),
  WITHDRAWAL("11")
  ;

  private final String code;

  public static UserStatusType ofCode(String code) {
    return Arrays.stream(UserStatusType.values())
        .filter(v -> v.getCode().equals(code))
        .findAny()
        .orElseThrow(NoSuchElementException::new);
  }


}
