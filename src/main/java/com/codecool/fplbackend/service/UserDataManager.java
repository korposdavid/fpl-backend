package com.codecool.fplbackend.service;

import com.codecool.fplbackend.model.Player;
import com.codecool.fplbackend.model.User;
import com.codecool.fplbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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

    public void saveTeam(List<Integer> playerIds, User user){
        List<Player> players = footballDataManager.getPlayers(playerIds);
        Set<Player> newSquad = new HashSet<>(players);
        user.setSquad(newSquad);
        userRepository.saveAndFlush(user);
    }

    public User getUserForOAuthUser(OAuth2User user) {
        Integer githubId = user.getAttribute("id");
        return getUserByGithubId(githubId);
    }
}
