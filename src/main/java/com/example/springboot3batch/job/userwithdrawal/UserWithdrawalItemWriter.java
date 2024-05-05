package com.example.springboot3batch.job.userwithdrawal;

import com.example.springboot3batch.model.UserWithdrawal;
import com.example.springboot3batch.repository.user.UserWithdrawalRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserWithdrawalItemWriter implements ItemWriter<UserWithdrawal> {

  private final UserWithdrawalRepository userWithdrawalRepository;

  @Override
  public void write(Chunk<? extends UserWithdrawal> data) {
    log.info("[User Withdrawal] Task-3. ItemWriter");
    Optional.ofNullable(data.getItems())
        .orElseThrow(RuntimeException::new)
        .forEach(this::saveHistory);
  }

  private void saveHistory(UserWithdrawal userWithdrawal) {
    userWithdrawalRepository.save(userWithdrawal);
  }
}
