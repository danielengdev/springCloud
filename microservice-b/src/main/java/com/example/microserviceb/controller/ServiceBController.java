package com.example.microserviceb.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * REST Controller for Microservice B.
 * Provides endpoints for basic operations.
 */
@RestController
@RequestMapping("/")
public class ServiceBController {

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
        response.put("description", "This is Microservice B");
        response.put("version", "1.0.0");
        
        Map<String, String> features = new HashMap<>();
        features.put("feature1", "Advanced REST API");
        features.put("feature2", "Service Discovery with Eureka");
        features.put("feature3", "Path Variable Support");
        
        response.put("features", features);
        
        return ResponseEntity.ok(response);
    }

    /**
     * Main endpoint for Microservice B.
     * 
     * @return A response with service-specific data
     */
    @GetMapping
    public ResponseEntity<Map<String, Object>> serviceB() {
        Map<String, Object> response = new HashMap<>();
        response.put("service", applicationName);
        response.put("message", "Hello from Microservice B!");
        response.put("timestamp", System.currentTimeMillis());
        
        return ResponseEntity.ok(response);
    }
    
    /**
     * Endpoint with path variable to demonstrate more complex REST API.
     * 
     * @param id The ID parameter from the path
     * @return A response with the ID and service information
     */
    @GetMapping("/data/{id}")
    public ResponseEntity<Map<String, Object>> getData(@PathVariable String id) {
        Map<String, Object> response = new HashMap<>();
        response.put("service", applicationName);
        response.put("id", id);
        response.put("message", "Data retrieved from Microservice B");
        response.put("timestamp", System.currentTimeMillis());
        
        return ResponseEntity.ok(response);
    }
}