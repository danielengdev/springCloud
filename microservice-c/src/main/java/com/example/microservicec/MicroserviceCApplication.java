package com.example.microservicec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableDiscoveryClient
@EnableJpaRepositories(basePackages = "com.example.microservicec.infrastructure.repository")
public class MicroserviceCApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceCApplication.class, args);
    }
}
