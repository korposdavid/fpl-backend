package com.codecool.fplbackend.service;

import com.codecool.fplbackend.model.Player;
import com.codecool.fplbackend.model.Team;
import com.codecool.fplbackend.repository.PlayerRepository;
import com.codecool.fplbackend.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FootballDataManager {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private TeamRepository teamRepository;

    public Player getPlayer(Long id) {
        Player result = playerRepository.getOne(id);
        connectPlayerWithTeam(result);
        return result;
    }

    public List<Player> getPlayers(List<Integer> ids) {
        List<Long> idsToFind = new ArrayList<>();
        for (Integer id: ids
             ) {
            idsToFind.add(Long.valueOf(id));
        }
        return playerRepository.findAllById(idsToFind);
    }

    public List<Player> getPlayersByNamePart(String namePart){
        return playerRepository.getTop10ByFullNameIsContainingIgnoreCaseOrderByFormDesc(namePart);
    }

    public Team getTeam(Long id) {
        return teamRepository.getOne(id);
    }

    public void connectPlayerWithTeam(Player player) {
        if (player.getTeamObject() == null) {
            Team team = getTeam(player.getTeam());
            team.getPlayers().add(player);
            player.setTeamObject(team);
            playerRepository.saveAndFlush(player);
        }
    }

}
