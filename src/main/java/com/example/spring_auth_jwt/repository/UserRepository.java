package com.example.spring_auth_jwt.repository;

import com.example.spring_auth_jwt.domain.UserDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserDomain, Long> {
    Optional<UserDomain> findByEmail(String email);
}
