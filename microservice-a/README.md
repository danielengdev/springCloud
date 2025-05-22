# Microservice A

## Overview
Microservice A is a simple Spring Boot application that provides basic REST API endpoints. It registers with Eureka for service discovery and can be accessed through the API Gateway.

## Features
- Basic REST API endpoints
- Service discovery with Eureka
- Health and info endpoints for monitoring

## Endpoints
- `/` - Main endpoint that returns basic service information
- `/health` - Health check endpoint
- `/info` - Detailed information about the service

## Configuration
The service is configured with the following properties:
- Application name: microservice-a
- Server port: 8081
- Eureka client: Registers with Eureka server at http://localhost:8761/eureka/

## Usage
To access Microservice A through the API Gateway:
```
http://localhost:8080/api/service-a/
```

To access Microservice A directly:
```
http://localhost:8081/
```

## Dependencies
- Spring Boot Web
- Spring Cloud Netflix Eureka Client
- Spring Boot Actuator