package com.codecool.fplbackend.service;

import com.codecool.fplbackend.model.Player;
import com.codecool.fplbackend.repository.FixtureRepository;
import com.codecool.fplbackend.repository.PlayerRepository;
import com.codecool.fplbackend.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataInitializer {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private FixtureRepository fixtureRepository;

    @Autowired
    private FPLApiService fplApiService;

    public void initialize() {
        initializePlayers();
        teamRepository.saveAll(fplApiService.fetchTeamData());
        fixtureRepository.saveAll(fplApiService.fetchFixtureData());
    }

    private void initializePlayers() {
        List<Player> players = fplApiService.fetchPlayerData();
        players.forEach(player -> player.setFullName(player.getFirst_name().concat(player.getSecond_name())));
        playerRepository.saveAll(players);
    }

}
