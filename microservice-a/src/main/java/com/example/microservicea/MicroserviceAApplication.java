package com.example.microservicea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Main application class for Microservice A.
 * This microservice registers with Eureka for service discovery.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MicroserviceAApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceAApplication.class, args);
    }
}