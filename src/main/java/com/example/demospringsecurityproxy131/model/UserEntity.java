package com.example.demospringsecurityproxy131.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class UserEntity {

    @Id
    @GeneratedValue
    private Integer id;

    private String mail;

    private String password;

}
