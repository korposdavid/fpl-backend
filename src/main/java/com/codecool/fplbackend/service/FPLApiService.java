package com.codecool.fplbackend.service;

import com.codecool.fplbackend.model.FPLData;
import com.codecool.fplbackend.model.Fixture;
import com.codecool.fplbackend.model.Player;
import com.codecool.fplbackend.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class FPLApiService {

    @Autowired
    private RestTemplate restTemplate;

    public List<Player> fetchPlayerData(){
        String url = "https://fantasy.premierleague.com/api/bootstrap-static/";

        ResponseEntity<FPLData> responseData = restTemplate.getForEntity(url, FPLData.class);

        return Objects.requireNonNull(responseData.getBody()).getElements();
    }

    public List<Team> fetchTeamData(){
        String url = "https://fantasy.premierleague.com/api/bootstrap-static/";

        ResponseEntity<FPLData> responseData = restTemplate.getForEntity(url, FPLData.class);

        return Objects.requireNonNull(responseData.getBody()).getTeams();
    }

    public List<Fixture> fetchFixtureData(){
        String url = "https://fantasy.premierleague.com/api/fixtures/";

        ResponseEntity<Fixture[]> responseData = restTemplate.getForEntity(url, Fixture[].class);

        return Arrays.asList(Objects.requireNonNull(responseData.getBody()));
    }
}
