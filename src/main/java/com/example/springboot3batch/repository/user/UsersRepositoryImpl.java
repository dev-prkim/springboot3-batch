package com.example.springboot3batch.repository.user;

import com.example.springboot3batch.model.QUsers;
import com.example.springboot3batch.model.Users;
import com.example.springboot3batch.model.type.UserStatusType;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UsersRepositoryImpl implements QUsersRepository {

  private final JPAQueryFactory query;

  QUsers users = QUsers.users;

  @Override
  public List<Users> findWithdrawalPendingUsers() {
    return query
        .selectFrom(users)
        .where(
            eqStatus(UserStatusType.WITHDRAWAL_PENDING),
            isDeleteAtPassed()
        )
        .fetch();
  }

  private BooleanExpression eqStatus(UserStatusType status) {
    return users.status.eq(status);
  }

  private BooleanExpression isDeleteAtPassed() {
    return users.deleteAt.before(LocalDateTime.now());
  }
}
