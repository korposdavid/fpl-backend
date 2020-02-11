package com.codecool.fplbackend;

import com.codecool.fplbackend.model.Player;
import com.codecool.fplbackend.repository.PlayerRepository;
import com.codecool.fplbackend.repository.TeamRepository;
import com.codecool.fplbackend.service.FPLApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
public class FplBackendApplication {
    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private TeamRepository teamRepository;

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
            teamRepository.saveAll(fplApiService.fetchTeamData());
        };
    }
}
