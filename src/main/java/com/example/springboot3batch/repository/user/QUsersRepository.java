package com.example.springboot3batch.repository.user;

import com.example.springboot3batch.model.Users;
import java.util.List;

public interface QUsersRepository {
  List<Users> findWithdrawalPendingUsers();
}
