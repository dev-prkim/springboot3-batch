package com.example.springboot3batch.model;

import com.example.springboot3batch.model.type.UserStatusType;
import com.example.springboot3batch.model.type.converter.UserStatusConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Users {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idx;

  @Column(nullable = false, unique = true)
  private String username;

  @Column(nullable = false)
  private String password;

  private String name;

  @Convert(converter = UserStatusConverter.class)
  @Column(nullable = false)
  @Builder.Default
  private UserStatusType status = UserStatusType.ACTIVE;

  @Comment("탈퇴 회원 삭제 예정일시")
  private LocalDateTime deleteAt;

  public void onWithdrawalRequest() {
    int daysUntilDeletion = 3;
    this.status = UserStatusType.WITHDRAWAL_PENDING;
    this.deleteAt = LocalDateTime.now().plusDays(daysUntilDeletion);
  }

}
