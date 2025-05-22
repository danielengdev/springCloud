# Microservice B

## Overview
Microservice B is a Spring Boot application that provides REST API endpoints with more advanced features like path variables. It registers with Eureka for service discovery and can be accessed through the API Gateway.

## Features
- Advanced REST API endpoints
- Path variable support
- Service discovery with Eureka
- Health and info endpoints for monitoring

## Endpoints
- `/` - Main endpoint that returns basic service information
- `/health` - Health check endpoint
- `/info` - Detailed information about the service
- `/data/{id}` - Endpoint that accepts a path variable and returns data based on the ID

## Configuration
The service is configured with the following properties:
- Application name: microservice-b
- Server port: 8082
- Eureka client: Registers with Eureka server at http://localhost:8761/eureka/

## Usage
To access Microservice B through the API Gateway:
```
http://localhost:8080/api/service-b/
http://localhost:8080/api/service-b/data/123
```

To access Microservice B directly:
```
http://localhost:8082/
http://localhost:8082/data/123
```

## Dependencies
- Spring Boot Web
- Spring Cloud Netflix Eureka Client
- Spring Boot Actuator