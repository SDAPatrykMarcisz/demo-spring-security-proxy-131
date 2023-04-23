package com.example.demospringsecurityproxy131.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(csrf -> csrf.disable()); //wylaczamy csrf bo nie korzystamy z frontu, tylko REST-a
        httpSecurity.authorizeHttpRequests(
                (request -> request.requestMatchers(HttpMethod.POST, "/users").permitAll())  //kazdy moze wywolac zapytanie dla endpointu /users metoda POST
        );
        return httpSecurity.build();
    }

}
