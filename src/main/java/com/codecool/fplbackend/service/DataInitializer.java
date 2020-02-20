package com.codecool.fplbackend.service;

import com.codecool.fplbackend.repository.FixtureRepository;
import com.codecool.fplbackend.repository.PlayerRepository;
import com.codecool.fplbackend.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        playerRepository.saveAll(fplApiService.fetchPlayerData());
        teamRepository.saveAll(fplApiService.fetchTeamData());
        fixtureRepository.saveAll(fplApiService.fetchFixtureData());
    }

}
