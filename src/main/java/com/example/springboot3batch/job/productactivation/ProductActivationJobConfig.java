package com.example.springboot3batch.job.productactivation;

import com.example.springboot3batch.model.Product;
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
public class ProductActivationJobConfig {

  private final ProductActivationItemReader itemReader;
  private final ProductActivationItemProcessor itemProcessor;
  private final ProductActivationItemWriter itemWriter;

  @Bean
  public Job productActivationJob(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
    return new JobBuilder("product-activation-job", jobRepository)
        .flow(productActivationStep(jobRepository, transactionManager))
        .end()
        .build();
  }

  @Bean
  public Step productActivationStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
    return new StepBuilder("product-activation-step", jobRepository)
        .<Product, Product>chunk(1, transactionManager)
        .reader(itemReader)
        .processor(itemProcessor)
        .writer(itemWriter)
        .build();
  }

}
