package com.example.spring_auth_jwt.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "roles")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RoleDomain {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public RoleDomain(String name) {
        this.name = name;
    }
}
