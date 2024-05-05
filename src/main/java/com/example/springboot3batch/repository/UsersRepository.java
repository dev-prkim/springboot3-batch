package com.example.springboot3batch.repository;

import com.example.springboot3batch.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long>, QUsersRepository {

}
