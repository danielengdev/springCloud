# API Gateway

## Overview
The API Gateway serves as the single entry point for all client requests in the microservices architecture. It routes requests to the appropriate microservice, provides cross-cutting concerns like security, monitoring, and resilience.

## Features
- **Routing**: Routes requests to appropriate microservices based on the path
- **Load Balancing**: Uses client-side load balancing via Eureka
- **Retry Mechanism**: Automatically retries failed requests
- **Fallback Responses**: Provides meaningful responses when services are unavailable

## Configuration
The API Gateway is configured to route requests as follows:

- `/api/service-a/**` → Microservice A
- `/api/service-b/**` → Microservice B

## Fallback Endpoints
When a service is unavailable, the API Gateway provides fallback responses:

- `/fallback/service-a` - Fallback for Microservice A
- `/fallback/service-b` - Fallback for Microservice B
- `/fallback/default` - Default fallback for any service

## Technical Details

### Dependencies
- Spring Cloud Gateway
- Spring Cloud Netflix Eureka Client
- Spring Boot Actuator

### Configuration Properties
Key configuration properties in `application.properties`:

```properties
# Application name and server port
spring.application.name=api-gateway
server.port=8080

# Eureka client configuration
eureka.client.service-url.defaultZone=http://localhost:8761/eureka/
```

### Retry Configuration
The gateway is configured to retry failed requests up to 3 times for the following HTTP status codes:
- 500 (Internal Server Error)
- 502 (Bad Gateway)
- 503 (Service Unavailable)

## Usage
To access a microservice through the API Gateway:

1. Ensure the API Gateway is running
2. Send requests to the API Gateway using the appropriate path:
   - `http://localhost:8080/api/service-a/resource` for Microservice A
   - `http://localhost:8080/api/service-b/resource` for Microservice B