package com.example.spring_auth_jwt.controller;

import com.example.spring_auth_jwt.model.LoginRequestModel;
import com.example.spring_auth_jwt.service.UserService;
import com.example.spring_auth_jwt.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    @Autowired
    private UserService service;
    @Autowired
    private AuthenticationManager authManager;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public Map<String, Object> loginHandler(@RequestBody LoginRequestModel body) {
        System.out.println(body);
        try {
            var auth = new UsernamePasswordAuthenticationToken(body.getUsername(), body.getPassword());
            authManager.authenticate(auth);
            var token = jwtUtil.generateToken(body.getUsername());
            return Collections.singletonMap("jwt-token", token);
        } catch (Exception authExc) {
            System.out.println(authExc.getMessage());
            throw new RuntimeException("Invalid Login Credentials");
        }
    }

//    @PostMapping("/login")
//    public ResponseEntity<UserDomain> login(@RequestBody LoginRequestModel body) {
//        try {
//            var authInputToken = new UsernamePasswordAuthenticationToken(body.getUsername(), body.getPassword());
//            authManager.authenticate(authInputToken);
//
//            String token = jwtUtil.generateToken(body.getEmail());
//
//            return Collections.singletonMap("jwt-token", token);
//        } catch (AuthenticationException authExc) {
//            throw new RuntimeException("Invalid Login Credentials");
//        }
//        return ResponseEntity.ok().body(user);
//    }
}
