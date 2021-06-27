package com.repos;

import com.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

public interface UserRepo extends JpaRepository<User, Integer> {
    @Override
    @Modifying
    <S extends User> S saveAndFlush(S s);
}
