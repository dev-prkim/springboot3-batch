package com.example.springboot3batch.job.userwithdrawal;

import com.example.springboot3batch.model.UserWithdrawal;
import com.example.springboot3batch.model.Users;
import com.example.springboot3batch.model.type.UserStatusType;
import com.example.springboot3batch.repository.user.UsersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserWithdrawalItemProcessor implements ItemProcessor<Users, UserWithdrawal> {

  private final UsersRepository usersRepository;

  @Override
  public UserWithdrawal process(Users user) throws Exception {
    log.info("[User Withdrawal] Task-2. ItemProcessor userIdx: {}", user.getIdx());
    return processUserWithdrawal(user);
  }

  private UserWithdrawal processUserWithdrawal(Users user) throws Exception {

    try {
      UserWithdrawal userWithdrawal = createUserWithdrawal(user);
      deleteUser(user);
      return userWithdrawal;
    } catch (Exception e) {
      log.error("Error occurred while withdrawing the user", e);
      throw new Exception("Error occurred while withdrawing the user", e);
    }

  }

  private UserWithdrawal createUserWithdrawal(Users user) {
    return UserWithdrawal.builder()
        .idx(user.getIdx())
        .username(user.getUsername())
        .name(user.getName())
        .status(UserStatusType.WITHDRAWAL.getCode())
        .deleteAt(user.getDeleteAt())
        .build();
  }

  private void deleteUser(Users user) {
    usersRepository.delete(user);
  }

}
