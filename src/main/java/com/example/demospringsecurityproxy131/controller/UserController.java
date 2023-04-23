package com.example.demospringsecurityproxy131.controller;

import com.example.demospringsecurityproxy131.model.User;
import com.example.demospringsecurityproxy131.model.UserEntity;
import com.example.demospringsecurityproxy131.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/users")
    public void createUser(@RequestBody User newUser) {
        UserEntity userEntity = new UserEntity();
        userEntity.setMail(newUser.getMail());
        userEntity.setPassword(newUser.getPassword());
        userRepository.save(userEntity);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/users")
    public List<UserEntity> getAllUsers(){
        return userRepository.findAll();
    }

}
