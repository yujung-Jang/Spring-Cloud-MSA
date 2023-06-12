package com.yujung.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {

        return builder.routes()
                // first-service
                .route(r -> r.path("/first-service/**") // 요청이 들어오면
                        .uri("http://localhost:8081")) // 요청 전달
                // second-service
                .route(r -> r.path("/second-service/**")
                        .filters(f -> f.addRequestHeader("second-request", "second-request-header")
                                .addRequestHeader("second-response", "second-response-header"))
                        .uri("http://localhost:8082"))
                .build();
    }
}
