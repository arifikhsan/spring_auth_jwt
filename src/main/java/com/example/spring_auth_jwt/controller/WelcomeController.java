package com.example.spring_auth_jwt.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class WelcomeController {

    @GetMapping("/welcome")
    public ResponseEntity<HashMap<String, String>> hello() {
        HashMap<String, String> message = new HashMap<>();
        message.put("message", "hello world");
        return ResponseEntity.ok().body(message);
    }
}
