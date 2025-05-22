package com.example.apigateway.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Controller to handle fallback scenarios when services are unavailable.
 */
@RestController
@RequestMapping("/fallback")
public class FallbackController {

    /**
     * Fallback method for microservice-a.
     * 
     * @return A response entity with a message indicating the service is unavailable
     */
    @GetMapping("/service-a")
    public ResponseEntity<Map<String, String>> serviceFallback() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "error");
        response.put("message", "Service A is currently unavailable. Please try again later.");
        
        return new ResponseEntity<>(response, HttpStatus.SERVICE_UNAVAILABLE);
    }

    /**
     * Fallback method for microservice-b.
     * 
     * @return A response entity with a message indicating the service is unavailable
     */
    @GetMapping("/service-b")
    public ResponseEntity<Map<String, String>> serviceB() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "error");
        response.put("message", "Service B is currently unavailable. Please try again later.");
        
        return new ResponseEntity<>(response, HttpStatus.SERVICE_UNAVAILABLE);
    }

    /**
     * Default fallback method for any service.
     * 
     * @return A response entity with a message indicating a service is unavailable
     */
    @GetMapping("/default")
    public ResponseEntity<Map<String, String>> defaultFallback() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "error");
        response.put("message", "The requested service is currently unavailable. Please try again later.");
        
        return new ResponseEntity<>(response, HttpStatus.SERVICE_UNAVAILABLE);
    }
}