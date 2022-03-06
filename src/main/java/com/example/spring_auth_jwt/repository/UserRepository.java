package com.example.spring_auth_jwt.repository;

import com.example.spring_auth_jwt.domain.UserDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDomain, Long> {
    UserDomain findByEmail(String email);

    UserDomain findByUsername(String username);
}
