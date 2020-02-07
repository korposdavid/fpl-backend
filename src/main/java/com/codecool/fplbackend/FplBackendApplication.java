package com.codecool.fplbackend;

import com.codecool.fplbackend.model.Player;
import com.codecool.fplbackend.model.User;
import com.codecool.fplbackend.repository.PlayerRepository;
import com.codecool.fplbackend.repository.UserRepository;
import com.codecool.fplbackend.service.FPLApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@SpringBootApplication
public class FplBackendApplication {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private FPLApiService fplApiService;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(FplBackendApplication.class, args);
    }

    @Bean
    public CommandLineRunner init() {
        return args -> {
            playerRepository.saveAll(fplApiService.fetchPlayerData());

            List<Long> playerIds = new ArrayList<>(Arrays.asList(47L,181L,65L,128L,297L,191L,215L,342L,150L,67L,187L,93L,164L,468L,271L));

            List<Player> players = playerRepository.findAllById(playerIds);

            User user = User.builder().team(new HashSet<>(players)).username("test_user").build();

            userRepository.save(user);
        };
    }
}
