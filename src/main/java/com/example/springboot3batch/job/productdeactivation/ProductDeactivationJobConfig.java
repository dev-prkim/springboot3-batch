package com.example.springboot3batch.job.productdeactivation;

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
public class ProductDeactivationJobConfig {

  private final ProductDeactivationItemReader itemReader;
  private final ProductDeactivationItemProcessor itemProcessor;
  private final ProductDeactivationItemWriter itemWriter;

  @Bean
  public Job productDeactivationJob(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
    return new JobBuilder("product-deactivation-job", jobRepository)
        .flow(productDeactivationStep(jobRepository, transactionManager))
        .end()
        .build();
  }

  @Bean
  public Step productDeactivationStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
    return new StepBuilder("product-deactivation-step", jobRepository)
        .<Product, Product>chunk(1, transactionManager)
        .reader(itemReader)
        .processor(itemProcessor)
        .writer(itemWriter)
        .build();
  }

}
