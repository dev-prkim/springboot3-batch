package com.example.springboot3batch.scheduler;

import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserWithdrawalScheduler {

  private final JobLauncher jobLauncher;
  private final Job userWithdrawalJob;

  @Scheduled(cron = "0 0 3 * * *") // 매일 03시
  public void scheduleUserWithdrawalJob()
      throws JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {
    log.info("User withdrawal job starting");
    JobParameters jobParameters = new JobParametersBuilder()
        .addLocalDateTime("startAt", LocalDateTime.now())
        .toJobParameters();
    jobLauncher.run(userWithdrawalJob, jobParameters);
  }

}
