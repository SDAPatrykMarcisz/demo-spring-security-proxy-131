package com.example.demospringsecurityproxy131.config;

import com.example.demospringsecurityproxy131.entity.UserEntity;
import com.example.demospringsecurityproxy131.repository.AuthorityRepository;
import com.example.demospringsecurityproxy131.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
@Order(2)
public class AdminUserInitializer implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthorityRepository authorityRepository;

    @Value("${spring.security.user.name}")
    private String adminName;
    @Value("${spring.security.user.password}")
    private String adminPassword;

    @Override
    public void run(String... args) throws Exception {
        UserEntity userEntity = new UserEntity();

        userEntity.setEmail(adminName);
        userEntity.setPassword(passwordEncoder.encode(adminPassword));
        userEntity.setAuthorities(authorityRepository
                .findByName("ADMIN")
                .map(x -> Collections.singletonList(x))
                .orElseThrow()
        );
        userRepository.save(userEntity);
    }
}
