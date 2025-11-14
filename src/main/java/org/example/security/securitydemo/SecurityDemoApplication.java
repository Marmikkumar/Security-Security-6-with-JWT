package org.example.security.securitydemo;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EntityScan(basePackages = "org.example.security.securitydemo.model")
@EnableJpaRepositories("org.example.security.securitydemo.repository")
public class SecurityDemoApplication {

    @Autowired
    private PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(SecurityDemoApplication.class, args);
    }


    @PostConstruct
    public void checkEncoder() {
        System.out.println("PasswordEncoder bean class -> " + passwordEncoder.getClass().getName());
        System.out.println("PASS " + new BCryptPasswordEncoder().encode("password123"));
        String hash = "$2a$10$C/uf3V2Bat7mgq3/WbYHi.Y/1l72hbzTpz5NnOvEM7snuWQasWO6i";
        System.out.println("test match: " + passwordEncoder.matches("password123", hash));
    }

}
