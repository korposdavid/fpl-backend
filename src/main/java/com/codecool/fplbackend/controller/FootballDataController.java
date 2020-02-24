package com.codecool.fplbackend.controller;

import com.codecool.fplbackend.model.Player;
import com.codecool.fplbackend.model.Team;
import com.codecool.fplbackend.service.FootballDataManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"}, allowedHeaders = {"*"},  allowCredentials = "true", methods = {RequestMethod.POST, RequestMethod.OPTIONS, RequestMethod.GET})
public class FootballDataController {
    @Autowired
    private FootballDataManager footballDataManager;

    @GetMapping("/player/{id}")
    public Player getPlayer(@PathVariable("id") Long id){
        return footballDataManager.getPlayer(id);
    }

    @GetMapping("/team/{id}")
    public Team getTeam(@PathVariable("id") Long id){
        return footballDataManager.getTeam(id);
    }

    @GetMapping("/players/name/{namePart}")
    public List<Player> getPlayersByName(@PathVariable("namePart") String namePart) {
        return footballDataManager.getPlayersByNamePart(namePart);
    }
}
