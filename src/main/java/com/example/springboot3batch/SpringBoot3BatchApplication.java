package com.example.springboot3batch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SpringBoot3BatchApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringBoot3BatchApplication.class, args);
  }
}