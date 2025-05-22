# Configuration Server

## Overview
The Configuration Server provides centralized configuration management for all microservices in the Spring Cloud architecture. It allows for externalized configuration, making it possible to manage configuration across different environments without rebuilding the application.

## Features
- **Centralized Configuration**: Single source of truth for application configuration
- **Environment-Specific Configuration**: Different configurations for different environments (dev, test, prod)
- **Runtime Configuration Changes**: Some properties can be changed at runtime without restarting applications
- **Native File System Support**: Configurations stored in the local file system

## Configuration Files
The server provides configuration for the following services:
- **API Gateway**: Routing and gateway-specific configurations
- **Microservice A**: Basic service configuration and custom properties
- **Microservice B**: Advanced service configuration with path variable support

## Technical Details

### Dependencies
- Spring Cloud Config Server
- Spring Boot Actuator
- Spring Boot DevTools

### Configuration Properties
Key configuration properties in `application.properties`:

```properties
# Application name and server port
spring.application.name=config-server
server.port=8888

# Configuration repository location
spring.profiles.active=native
spring.cloud.config.server.native.search-locations=classpath:/config
```

## Usage
To access configuration for a specific service:

1. Ensure the Config Server is running
2. Access the configuration using one of the following patterns:
   - `http://localhost:8888/{service-name}/default` - Default configuration
   - `http://localhost:8888/{service-name}/{profile}` - Profile-specific configuration
   - `http://localhost:8888/{service-name}/{profile}/{label}` - Label-specific configuration

Example:
```
http://localhost:8888/microservice-a/default
```

## Client Configuration
Clients need to include the Spring Cloud Config Client dependency and configure their bootstrap.properties:

```properties
spring.application.name=service-name
spring.config.import=optional:configserver:http://localhost:8888
```