package com.codecool.fplbackend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"}, allowedHeaders = {"*"},  allowCredentials = "true", methods = {RequestMethod.POST, RequestMethod.OPTIONS, RequestMethod.GET})
public class UserController {
    private ClientRegistration registration;

    public UserController(ClientRegistrationRepository registrations) {
        this.registration = registrations.findByRegistrationId("github");
    }

    @GetMapping("/api/user")
    public ResponseEntity<?> getUser(@AuthenticationPrincipal OAuth2User user) {
        if (user == null) {
            return new ResponseEntity<>("", HttpStatus.OK);
        } else {
            //TODO: lookup user by attributes in userrepo => create if not exists
            return ResponseEntity.ok().body(user.getAttributes());
        }
    }

    @PostMapping("/api/logout")
    public ResponseEntity<?> logout(HttpServletRequest request, @AuthenticationPrincipal OAuth2User user) {
        request.getSession(false).invalidate();
        return new ResponseEntity<>("", HttpStatus.OK);
    }
}
