package com.example.spring_auth_jwt.repository;

import com.example.spring_auth_jwt.domain.RoleDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<RoleDomain, Long> {
    Optional<RoleDomain> findByName(String name);
}
