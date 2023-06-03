package com.example.demospringsecurityproxy131.scope.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.annotation.RequestScope;

import java.util.UUID;

@RequestScope
@Configuration
@Slf4j
public class ExampleBean {

    private String id;

    public ExampleBean() {
        this.id = UUID.randomUUID().toString();
    }

    public void testMethod(){
        log.info(id);
    }
}
