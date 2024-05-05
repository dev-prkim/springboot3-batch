package com.example.springboot3batch.repository;

import com.example.springboot3batch.model.UserWithdrawal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserWithdrawalRepository extends JpaRepository<UserWithdrawal, Long> {

}
