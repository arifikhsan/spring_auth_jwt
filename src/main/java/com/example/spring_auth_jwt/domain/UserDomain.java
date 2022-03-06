package com.example.spring_auth_jwt.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserDomain {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String email;
    private String password;

    @Transient
    @OneToMany(fetch = FetchType.EAGER)
    private Set<UserRoleDomain> userRoles;

    @Transient
    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<RoleDomain> roles;

    public UserDomain(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public UserDomain(String username, String password) {
        this.username = username;
        this.password = password;
    }
}