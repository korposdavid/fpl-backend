package com.codecool.fplbackend;

import com.codecool.fplbackend.model.Player;
import com.codecool.fplbackend.model.User;
import com.codecool.fplbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class FplBackendApplication {

    @Autowired
    private UserRepository userRepository;

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
            Player player1 = Player.builder().code(47).build();
            Player player2 = Player.builder().code(181).build();
            Player player3 = Player.builder().code(65).build();
            Player player4 = Player.builder().code(128).build();
            Player player5 = Player.builder().code(297).build();
            Player player6 = Player.builder().code(191).build();
            Player player7 = Player.builder().code(215).build();
            Player player8 = Player.builder().code(342).build();
            Player player9 = Player.builder().code(150).build();
            Player player10 = Player.builder().code(67).build();
            Player player11 = Player.builder().code(187).build();
            Player player12 = Player.builder().code(93).build();
            Player player13 = Player.builder().code(164).build();
            Player player14 = Player.builder().code(468).build();
            Player player15 = Player.builder().code(271).build();
            Set<Player> players = new HashSet<>(Arrays.asList(player10, player11, player12, player13, player14, player15, player1, player2, player3, player4, player5, player6, player7, player8, player9));

            User user = User.builder().team(players).username("test_user").build();

            userRepository.save(user);

        };
    }
}
