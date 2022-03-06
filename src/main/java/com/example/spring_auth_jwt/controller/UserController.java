package com.example.spring_auth_jwt.controller;

import com.example.spring_auth_jwt.domain.UserDomain;
import com.example.spring_auth_jwt.repository.UserRepository;
import com.example.spring_auth_jwt.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/users")
public class UserController {
    private final UserService service;

    @GetMapping
    public ResponseEntity<List<UserDomain>> all() {
        return ResponseEntity.ok().body(service.all());
    }

//    @GetMapping("{id}")
//    public ResponseEntity<UserDomain> one(@RequestParam Long id) {
//        return ResponseEntity.ok().body(service.all().stream().findFirst());
//    }

    @PostMapping
    public ResponseEntity<UserDomain> create(@RequestBody UserDomain user) {
        return ResponseEntity.ok().body(service.create(user));
    }
}
