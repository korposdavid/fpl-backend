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

    public User getUserByEmail(String email){
        Optional<User> user = userRepository.findUserByEmail(email);
        if (!user.isPresent()) {
            User newUser = User.builder().email(email).build();
            userRepository.saveAndFlush(newUser);
            return newUser;
        } else {
            return user.get();
        }
    }
}
