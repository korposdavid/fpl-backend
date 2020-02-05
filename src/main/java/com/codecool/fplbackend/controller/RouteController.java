package com.codecool.fplbackend.controller;

import com.codecool.fplbackend.model.FPLUserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin
public class RouteController {

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/fpl-api-login")
    public HttpHeaders ApiLogin(@RequestBody FPLUserData fplUserData){
        MultiValueMap<String, String> requestData = new LinkedMultiValueMap<>();
        requestData.add("login", fplUserData.getEmail());
        requestData.add("password", fplUserData.getPassword());
        requestData.add("redirect_uri", "https://fantasy.premierleague.com/a/login");
        requestData.add("app", "plfpl-web");

        HttpHeaders requestHeaders = new HttpHeaders();
        HttpEntity<MultiValueMap<String, String>> httpRequest = new HttpEntity<>(requestData, requestHeaders);

        HttpEntity<String> response = restTemplate.postForEntity(
                "https://users.premierleague.com/accounts/login/",
                httpRequest,
                String.class
        );
        return response.getHeaders();
    }
}
