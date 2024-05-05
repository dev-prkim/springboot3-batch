package com.example.springboot3batch.job.userwithdrawal;

import com.example.springboot3batch.model.UserWithdrawal;
import com.example.springboot3batch.model.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@RequiredArgsConstructor
public class UserWithdrawalJobConfig {

  private final UserWithdrawalItemReader itemReader;
  private final UserWithdrawalItemProcessor itemProcessor;
  private final UserWithdrawalItemWriter itemWriter;

  @Bean
  public Job userWithdrawalJob(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
    return new JobBuilder("user-withdrawal-job", jobRepository)
        .flow(userWithdrawalStep(jobRepository, transactionManager))
        .end()
        .build();
  }

  @Bean
  public Step userWithdrawalStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
    return new StepBuilder("user-withdrawal-step", jobRepository)
        .<Users, UserWithdrawal>chunk(1, transactionManager)
        .reader(itemReader)
        .processor(itemProcessor)
        .writer(itemWriter)
        .build();
  }
}
