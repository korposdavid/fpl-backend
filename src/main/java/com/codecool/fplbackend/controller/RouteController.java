package com.codecool.fplbackend.controller;

import com.codecool.fplbackend.model.FPLUserData;
import com.codecool.fplbackend.model.Player;
import com.codecool.fplbackend.repository.UserRepository;
import com.codecool.fplbackend.service.FPLApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@CrossOrigin
public class RouteController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FPLApiService fplApiService;

    @PostMapping("/fpl-api-login")
    public HttpHeaders ApiLogin(@RequestBody FPLUserData fplUserData){
        return fplApiService.login(fplUserData.getEmail(),fplUserData.getPassword());
    }

    @GetMapping("/my-team/{id}")
    public Set<Player> getTeam(@PathVariable("id") Long id){
        return userRepository.getOne(id).getTeam();
    }
}
