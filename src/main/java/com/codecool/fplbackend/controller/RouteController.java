package com.codecool.fplbackend.controller;

import com.codecool.fplbackend.model.Player;
import com.codecool.fplbackend.model.Team;
import com.codecool.fplbackend.repository.PlayerRepository;
import com.codecool.fplbackend.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
public class RouteController {
    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private TeamRepository teamRepository;

    @GetMapping("/player/{id}")
    public Player getPlayer(@PathVariable("id") Long id){
        return playerRepository.getOne(id);
    }

    @GetMapping("players/{ids}")
    public List<Player> getPlayers(@PathVariable("ids") List<Long> ids) {
        return playerRepository.findAllById(ids);
    }

    @GetMapping("/team/{id}")
    public Team getTeam(@PathVariable("id") Long id){
        return teamRepository.getOne(id);
    }
}
