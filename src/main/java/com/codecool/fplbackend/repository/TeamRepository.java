package com.codecool.fplbackend.repository;


import com.codecool.fplbackend.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
