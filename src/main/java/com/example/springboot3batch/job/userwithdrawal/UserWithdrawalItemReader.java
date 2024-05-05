package com.example.springboot3batch.job.userwithdrawal;

import com.example.springboot3batch.model.Users;
import com.example.springboot3batch.repository.user.UsersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.stereotype.Component;

@Slf4j
@StepScope
@Component
@RequiredArgsConstructor
public class UserWithdrawalItemReader implements ItemReader<Users> {

  private final UsersRepository usersRepository;

  @Override
  public Users read() {
    log.info("[User Withdrawal] Task-1. ItemReader");
    return new ListItemReader<>(usersRepository.findWithdrawalPendingUsers())
        .read();
  }

}
