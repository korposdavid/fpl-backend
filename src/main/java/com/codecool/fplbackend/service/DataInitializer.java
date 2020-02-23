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
        teamRepository.saveAll(fplApiService.fetchTeamData());
        fixtureRepository.saveAll(fplApiService.fetchFixtureData());
        initializePlayers();
        initInitialUser();
    }

    private void initializePlayers() {
        List<Player> players = fplApiService.fetchPlayerData();
        players.forEach(player -> {
            player.setFullName(player.getFirst_name().concat(" ").concat(player.getSecond_name()));
            footballDataManager.connectPlayerWithTeam(player);
        });
        playerRepository.saveAll(players);
    }

    private void initInitialUser() {
        List<Integer> ids = List.of(47, 181, 65, 308,291,191,215,342,150,313,187,93,468,164,271);
        Set<Player> squad = Sets.newHashSet(footballDataManager.getPlayers(ids));

        User user = User.builder().githubId(48950847).squad(squad).build();
        userRepository.save(user);
    }

}
