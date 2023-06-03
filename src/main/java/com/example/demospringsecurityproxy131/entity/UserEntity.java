package com.example.demospringsecurityproxy131.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class UserEntity {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    private String email;

    private String password;

    @ManyToMany
    private List<AuthorityEntity> authorities;
}
