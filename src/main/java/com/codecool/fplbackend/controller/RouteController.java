package com.codecool.fplbackend.controller;

import com.codecool.fplbackend.model.Player;
import com.codecool.fplbackend.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
public class RouteController {
    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping("/player/{id}")
    public Player getPlayer(@PathVariable("id") Long id){
        return playerRepository.getOne(id);
    }
}
