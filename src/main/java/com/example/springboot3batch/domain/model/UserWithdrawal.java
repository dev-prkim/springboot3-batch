package com.example.springboot3batch.domain.model;

import com.example.springboot3batch.domain.model.type.UserStatusType;
import com.example.springboot3batch.domain.model.type.converter.UserStatusConverter;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserWithdrawal {

  @Id
  private Long idx;

  private String username;

  private String password;

  private String name;

  @Convert(converter = UserStatusConverter.class)
  private UserStatusType status;

  private LocalDateTime deleteAt;
}
