package com.codecool.fplbackend.controller;

import com.codecool.fplbackend.model.Player;
import com.codecool.fplbackend.model.Team;
import com.codecool.fplbackend.service.DataManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
public class RouteController {
    @Autowired
    private DataManager dataManager;

    @GetMapping("/player/{id}")
    public Player getPlayer(@PathVariable("id") Long id){
        return dataManager.getPlayer(id);
    }

    @GetMapping("players/{ids}")
    public List<Player> getPlayers(@PathVariable("ids") List<Long> ids) {
        return dataManager.getPlayers(ids);
    }

    @GetMapping("/team/{id}")
    public Team getTeam(@PathVariable("id") Long id){
        return dataManager.getTeam(id);
    }
}
