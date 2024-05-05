package com.example.springboot3batch.model;

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

  private String status;

  private LocalDateTime deleteAt;

}
