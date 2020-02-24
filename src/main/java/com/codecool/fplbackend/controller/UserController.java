package com.codecool.fplbackend.controller;

import com.codecool.fplbackend.model.InvalidSquadException;
import com.codecool.fplbackend.model.PlayerIdsContainer;
import com.codecool.fplbackend.model.User;
import com.codecool.fplbackend.service.UserDataManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"}, allowedHeaders = {"*"},  allowCredentials = "true", methods = {RequestMethod.POST, RequestMethod.OPTIONS, RequestMethod.GET})
public class UserController {

    @Autowired
    private UserDataManager userDataManager;

    @GetMapping("/api/user")
    public ResponseEntity<?> getUser(@AuthenticationPrincipal OAuth2User user) {
        if (user == null) {
            return new ResponseEntity<>("", HttpStatus.OK);
        } else {
            User loggedInUser = userDataManager.getUserForOAuthUser(user);
            return ResponseEntity.ok().body(loggedInUser);
        }
    }

    @PostMapping("/api/logout")
    public ResponseEntity<?> logout(HttpServletRequest request, @AuthenticationPrincipal OAuth2User user) {
        request.getSession(false).invalidate();
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @PostMapping("/squad")
    public ResponseEntity<?> saveSquad(@RequestBody PlayerIdsContainer playerIds, @AuthenticationPrincipal OAuth2User user){
        try{
            userDataManager.saveSquad(playerIds.getPlayers(), userDataManager.getUserForOAuthUser(user));
            return new ResponseEntity<>("Squad saved successfully", HttpStatus.OK);
        } catch (InvalidSquadException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
