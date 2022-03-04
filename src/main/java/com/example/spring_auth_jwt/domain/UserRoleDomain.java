package com.example.spring_auth_jwt.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "user_roles")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserRoleDomain {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserDomain user;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleDomain role;

    public UserRoleDomain(UserDomain user, RoleDomain role) {
        this.user = user;
        this.role = role;
    }
}
