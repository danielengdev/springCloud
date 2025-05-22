package com.example.microservicea.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * REST Controller for Microservice A.
 * Provides endpoints for basic operations.
 */
@RestController
@RequestMapping("/")
public class ServiceAController {

    @Value("${spring.application.name}")
    private String applicationName;

    /**
     * Basic health check endpoint.
     * 
     * @return A simple response indicating the service is up
     */
    @GetMapping("/health")
    public ResponseEntity<Map<String, String>> health() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "UP");
        response.put("service", applicationName);
        return ResponseEntity.ok(response);
    }

    /**
     * Information endpoint.
     * 
     * @return Basic information about the service
     */
    @GetMapping("/info")
    public ResponseEntity<Map<String, Object>> info() {
        Map<String, Object> response = new HashMap<>();
        response.put("name", applicationName);
        response.put("description", "This is Microservice A");
        response.put("version", "1.0.0");
        
        Map<String, String> features = new HashMap<>();
        features.put("feature1", "Basic REST API");
        features.put("feature2", "Service Discovery with Eureka");
        
        response.put("features", features);
        
        return ResponseEntity.ok(response);
    }

    /**
     * Main endpoint for Microservice A.
     * 
     * @return A response with service-specific data
     */
    @GetMapping
    public ResponseEntity<Map<String, Object>> serviceA() {
        Map<String, Object> response = new HashMap<>();
        response.put("service", applicationName);
        response.put("message", "Hello from Microservice A!");
        response.put("timestamp", System.currentTimeMillis());
        
        return ResponseEntity.ok(response);
    }
}