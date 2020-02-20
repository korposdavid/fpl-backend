package com.codecool.fplbackend.controller;

import com.codecool.fplbackend.model.Player;
import com.codecool.fplbackend.model.Team;
import com.codecool.fplbackend.service.FootballDataManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@EnableSwagger2
@RestController
@CrossOrigin(origins = {"http://localhost:3000"}, allowCredentials = "true")
public class FootballDataController {
    @Autowired
    private FootballDataManager footballDataManager;

    @GetMapping("/player?id={id}")
    public Player getPlayer(@PathVariable("id") Long id){
        return footballDataManager.getPlayer(id);
    }

    @GetMapping("players?ids={ids}")
    public List<Player> getPlayers(@PathVariable("ids") List<Long> ids) {
        return footballDataManager.getPlayers(ids);
    }

    @GetMapping("/team?id={id}")
    public Team getTeam(@PathVariable("id") Long id){
        return footballDataManager.getTeam(id);
    }

    @GetMapping("players?name={namePart}")
    public List<Player> getPlayers(@PathVariable("namePart") String namePart) {
        return footballDataManager.getPlayersByNamePart(namePart);
    }
}
