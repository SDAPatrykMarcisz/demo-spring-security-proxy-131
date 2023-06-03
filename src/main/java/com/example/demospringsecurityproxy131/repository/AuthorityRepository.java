package com.example.demospringsecurityproxy131.repository;

import com.example.demospringsecurityproxy131.entity.AuthorityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorityRepository extends JpaRepository<AuthorityEntity, Integer> {
    Optional<AuthorityEntity> findByName(String name);
}
