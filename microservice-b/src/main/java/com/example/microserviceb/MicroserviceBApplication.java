package com.example.microserviceb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Main application class for Microservice B.
 * This microservice registers with Eureka for service discovery.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MicroserviceBApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceBApplication.class, args);
    }
}