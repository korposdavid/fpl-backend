package com.codecool.fplbackend.repository;

import com.codecool.fplbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
