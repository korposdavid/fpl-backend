package com.codecool.fplbackend.repository;

import com.codecool.fplbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findUserByEmail(String email);

}
