package com.leandro.villela.Fortrek;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.leandro.villela")  // ← ADICIONAR
@EntityScan(basePackages = "com.leandro.villela.entity")
@EnableJpaRepositories(basePackages = "com.leandro.villela.repository")  // ← VERIFICAR
public class FortrekApplication {

    public static void main(String[] args) {
        SpringApplication.run(FortrekApplication.class, args);
    }
}