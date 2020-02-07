package com.codecool.fplbackend.repository;

import com.codecool.fplbackend.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
