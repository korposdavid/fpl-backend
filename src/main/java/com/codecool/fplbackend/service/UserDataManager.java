package com.codecool.fplbackend.service;

import com.codecool.fplbackend.model.User;
import com.codecool.fplbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDataManager {

    @Autowired
    private UserRepository userRepository;

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
}
