package com.codecool.fplbackend.repository;

import com.codecool.fplbackend.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long> {

    List<Player> getTop10ByFullNameIsContainingIgnoreCaseOrderByFormDesc(String name);
}
