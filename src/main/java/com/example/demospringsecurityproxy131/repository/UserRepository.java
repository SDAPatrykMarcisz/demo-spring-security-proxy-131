package com.example.demospringsecurityproxy131.repository;

import com.example.demospringsecurityproxy131.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
