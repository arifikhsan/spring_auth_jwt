package com.example.spring_auth_jwt.model;

import lombok.*;

@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class LoginRequestModel {
    private String username;
    private String password;
}
