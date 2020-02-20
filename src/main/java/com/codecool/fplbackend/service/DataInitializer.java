package com.codecool.fplbackend.service;

import com.codecool.fplbackend.model.Player;
import com.codecool.fplbackend.model.User;
import com.codecool.fplbackend.repository.FixtureRepository;
import com.codecool.fplbackend.repository.PlayerRepository;
import com.codecool.fplbackend.repository.TeamRepository;
import com.codecool.fplbackend.repository.UserRepository;
import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class DataInitializer {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private FixtureRepository fixtureRepository;

    @Autowired
    private FPLApiService fplApiService;

    @Autowired
    private FootballDataManager footballDataManager;

    @Autowired
    private UserRepository userRepository;

    public void initialize() {
        initializePlayers();
        teamRepository.saveAll(fplApiService.fetchTeamData());
        fixtureRepository.saveAll(fplApiService.fetchFixtureData());
        initInitialUser();
    }

    private void initializePlayers() {
        List<Player> players = fplApiService.fetchPlayerData();
        players.forEach(player -> player.setFullName(player.getFirst_name().concat(player.getSecond_name())));
        playerRepository.saveAll(players);
    }

    private void initInitialUser() {
        List<Long> ids = List.of(47L, 181L, 65L, 308L,291L,191L,215L,342L,150L,313L,187L,93L,468L,164L,271L);
        Set<Player> squad = Sets.newHashSet(footballDataManager.getPlayers(ids));

        User user = User.builder().githubId(48950847).squad(squad).build();
        userRepository.save(user);
    }

}
