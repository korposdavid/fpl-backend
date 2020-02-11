package com.codecool.fplbackend.repository;

import com.codecool.fplbackend.model.Fixture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FixtureRepository extends JpaRepository<Fixture, Long> {
}
