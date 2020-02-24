package com.codecool.fplbackend.service;

import com.codecool.fplbackend.model.InvalidSquadException;
import com.codecool.fplbackend.model.Player;
import com.codecool.fplbackend.model.User;
import com.codecool.fplbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserDataManager {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FootballDataManager footballDataManager;

    public User getUserByGithubId(Integer githubId){
        Optional<User> user = userRepository.findUserByGithubId(githubId);
        if (!user.isPresent()) {
            User newUser = User.builder().githubId(githubId).build();
            userRepository.saveAndFlush(newUser);
            return newUser;
        } else {
            return user.get();
        }
    }

    public void saveSquad(List<Integer> playerIds, User user) throws InvalidSquadException {
        List<Player> players = footballDataManager.getPlayers(playerIds);
        if (!checkSquadValidity(players)) {
            throw new InvalidSquadException("Squad is invalid");
        }
        Set<Player> newSquad = new HashSet<>(players);
        user.setSquad(newSquad);
        userRepository.saveAndFlush(user);
    }

    public User getUserForOAuthUser(OAuth2User user) {
        Integer githubId = user.getAttribute("id");
        return getUserByGithubId(githubId);
    }

    private boolean checkSquadValidity(List<Player> players){
        if (players.size() != 15) {
            return false;
        }
        HashMap<Integer, Integer> posCounter = new HashMap<>();
        for(Player player:players){
            Integer position = (int) player.getElement_type();
            if(!posCounter.containsKey(position)) {
                posCounter.put(position, 1);
            } else {
                posCounter.put(position, posCounter.get(position) + 1);
            }
        }
        return posCounter.get(1) == 2 && posCounter.get(2) == 5 && posCounter.get(3) == 5 && posCounter.get(4) == 3;
    }
}
