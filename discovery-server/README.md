# Discovery Server (Eureka)

## Overview
The Discovery Server provides service registration and discovery for all microservices in the Spring Cloud architecture. It allows services to find and communicate with each other without hardcoding hostname and port information.

## Features
- **Service Registration**: Microservices register themselves with the Eureka server
- **Service Discovery**: Microservices can discover and communicate with other services
- **Health Monitoring**: Monitors the health of registered services
- **Dashboard**: Web-based dashboard for viewing registered services

## Technical Details

### Dependencies
- Spring Cloud Netflix Eureka Server
- Spring Boot Actuator
- Spring Boot DevTools

### Configuration Properties
Key configuration properties in `application.properties`:

```properties
# Application name and server port
spring.application.name=discovery-server
server.port=8761

# Eureka server configuration
eureka.client.register-with-eureka=false
eureka.client.fetch-registry=false
```

## Usage
To access the Eureka Dashboard:

1. Ensure the Discovery Server is running
2. Open a web browser and navigate to:
   - `http://localhost:8761` - Main Eureka Dashboard
   - `http://localhost:8761/dashboard` - Alternative dashboard path

## Client Configuration
Microservices need to include the Eureka Client dependency and configure their application.properties:

```properties
# Eureka client configuration
eureka.client.service-url.defaultZone=http://localhost:8761/eureka/
eureka.instance.prefer-ip-address=true
```

## Registered Services
When fully operational, the following services should be registered:
- API Gateway
- Microservice A
- Microservice B

Each service will be listed in the Eureka Dashboard with its status, health, and metadata.