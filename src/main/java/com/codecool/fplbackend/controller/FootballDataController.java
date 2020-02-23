package com.codecool.fplbackend.controller;

import com.codecool.fplbackend.model.Player;
import com.codecool.fplbackend.model.PlayerIdsContainer;
import com.codecool.fplbackend.model.Team;
import com.codecool.fplbackend.model.User;
import com.codecool.fplbackend.service.FootballDataManager;
import com.codecool.fplbackend.service.UserDataManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"}, allowedHeaders = {"*"},  allowCredentials = "true", methods = {RequestMethod.POST, RequestMethod.OPTIONS, RequestMethod.GET})
public class FootballDataController {
    @Autowired
    private FootballDataManager footballDataManager;

    @Autowired
    private UserDataManager userDataManager;

    @GetMapping("/player/{id}")
    public Player getPlayer(@PathVariable("id") Long id){
        return footballDataManager.getPlayer(id);
    }

    /*@GetMapping("/players/{ids}")
    public List<Player> getPlayers(@PathVariable("ids") List<Long> ids) {
        return footballDataManager.getPlayers(ids);
    }*/

    @GetMapping("/team/{id}")
    public Team getTeam(@PathVariable("id") Long id){
        return footballDataManager.getTeam(id);
    }

    @PostMapping("/team")
    public void saveTeam(@RequestBody PlayerIdsContainer playerIds, @AuthenticationPrincipal OAuth2User user){
        //TODO: add data validation
        userDataManager.saveTeam(playerIds.getPlayers(), userDataManager.getUserForOAuthUser(user));
    }

    @GetMapping("/players/filter/{namePart}")
    public List<Player> filterPlayers(@PathVariable("namePart") String namePart) {
        return footballDataManager.getPlayersByNamePart(namePart);
    }
}
