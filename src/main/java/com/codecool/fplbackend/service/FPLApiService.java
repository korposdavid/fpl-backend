package com.codecool.fplbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class FPLApiService {

    @Autowired
    private RestTemplate restTemplate;

    public HttpHeaders login(String email, String password) {
        MultiValueMap<String, String> requestData = new LinkedMultiValueMap<>();
        requestData.add("login", email);
        requestData.add("password", password);
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
