package com.example.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 * Configuration class for API Gateway routes.
 * Defines the routing rules for forwarding requests to appropriate microservices.
 */
@Configuration
public class RouteConfig {

    /**
     * Configures routes for the API Gateway.
     * 
     * @param builder The RouteLocatorBuilder to build routes
     * @return A RouteLocator with the defined routes
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                // Route for microservice-a
                .route("microservice-a-route", r -> r.path("/api/service-a/**")
                        .filters(f -> f.stripPrefix(2)
                                .retry(config -> config.setRetries(3)
                                        .setStatuses(HttpStatus.INTERNAL_SERVER_ERROR, 
                                                    HttpStatus.BAD_GATEWAY,
                                                    HttpStatus.SERVICE_UNAVAILABLE)))
                        .uri("lb://MICROSERVICE-A"))

                // Route for microservice-b
                .route("microservice-b-route", r -> r.path("/api/service-b/**")
                        .filters(f -> f.stripPrefix(2)
                                .retry(config -> config.setRetries(3)
                                        .setStatuses(HttpStatus.INTERNAL_SERVER_ERROR, 
                                                    HttpStatus.BAD_GATEWAY,
                                                    HttpStatus.SERVICE_UNAVAILABLE)))
                        .uri("lb://MICROSERVICE-B"))

                // Route for microservice-c
                .route("microservice-c-route", r -> r.path("/api/service-c/**")
                        .filters(f -> f.stripPrefix(2)
                                .retry(config -> config.setRetries(3)
                                        .setStatuses(HttpStatus.INTERNAL_SERVER_ERROR,
                                                    HttpStatus.BAD_GATEWAY,
                                                    HttpStatus.SERVICE_UNAVAILABLE)))
                        .uri("lb://MICROSERVICE-C"))

                // Fallback routes
                .route("fallback-service-a", r -> r.path("/fallback/service-a")
                        .uri("forward:/fallback/service-a"))

                .route("fallback-service-b", r -> r.path("/fallback/service-b")
                        .uri("forward:/fallback/service-b"))

                .route("fallback-service-c", r -> r.path("/fallback/service-c")
                        .uri("forward:/fallback/service-c"))

                .route("fallback-default", r -> r.path("/fallback/default")
                        .uri("forward:/fallback/default"))

                .build();
    }
}
