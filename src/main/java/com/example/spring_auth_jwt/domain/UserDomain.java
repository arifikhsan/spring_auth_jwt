package com.example.spring_auth_jwt.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDomain {
    @Id
    @GeneratedValue
    private Long id;
    private String email;
    private String password;

    @Transient
    @OneToMany
    private Set<UserRoleDomain> userRoles;

    public UserDomain(String email, String password) {
        this.email = email;
        this.password = password;
    }
}