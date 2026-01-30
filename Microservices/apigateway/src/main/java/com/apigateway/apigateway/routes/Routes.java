package com.apigateway.apigateway.routes;

import java.net.URI;

import org.springframework.cloud.gateway.server.mvc.filter.CircuitBreakerFilterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;

@Configuration
public class Routes {

    @Bean
    public RouterFunction<ServerResponse> usermicroservice() {
        return GatewayRouterFunctions.route("usermicroservice")
                .route(RequestPredicates.path("/course-info/**"),
                        HandlerFunctions.http("http://localhost:8081"))
                		.filter(CircuitBreakerFilterFunctions.circuitBreaker("usermicroserviceCircuitBreaker",URI.create("forward:/fallbackRoute")))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> usermicroservice2() {
        return GatewayRouterFunctions.route("usermicroservice2")
                .route(RequestPredicates.path("/course-details/**"),
                        HandlerFunctions.http("http://localhost:8082"))
                .build();
    }
}
