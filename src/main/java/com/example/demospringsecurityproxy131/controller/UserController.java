package com.example.demospringsecurityproxy131.controller;

import com.example.demospringsecurityproxy131.entity.UserEntity;
import com.example.demospringsecurityproxy131.model.User;
import com.example.demospringsecurityproxy131.repository.AuthorityRepository;
import com.example.demospringsecurityproxy131.repository.UserRepository;
import com.example.demospringsecurityproxy131.scope.example.ExampleBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Collections;
import java.util.List;

@RestController
@Slf4j
public class UserController {


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthorityRepository authorityRepository;
    @Autowired
    public UserController(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthorityRepository authorityRepository){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authorityRepository = authorityRepository;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/users")
    public void createUser(@RequestBody User newUser){
        UserEntity userEntity = new UserEntity();

        userEntity.setEmail(newUser.getEmail());
        userEntity.setPassword(passwordEncoder.encode(newUser.getPassword()));
        userEntity.setAuthorities(authorityRepository
                .findByName("USER")
                .map(x -> Collections.singletonList(x))
                .orElseThrow()
        );
        userRepository.save(userEntity);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/users")
    public List<UserEntity> getAllUsers(){
        log.info("admin tu był");
        return userRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/users/info")
    public void displayUserInfoInLogs(Principal principal){
        String name = principal.getName();
        log.info(name);
        System.out.println(name);
    }
}
