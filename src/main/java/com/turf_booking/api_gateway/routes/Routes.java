package com.turf_booking.api_gateway.routes;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Routes {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("bookings-eapi",
                        r -> r.path("/question/**")
                                .uri("lb://BOOKINGS-EAPI"))
                .route("bookings-papi",
                        r -> r.path("/api/turf-booking/**")
                                .uri("lb://BOOKINGS-PAPI"))
                .route("booking-sapi",
                        r -> r.path("/booking-sapi/**")
                                .uri("lb://BOOKING-SAPI"))
                .route("turf-sapi",
                        r -> r.path("/turf-sapi/**")
                                .uri("lb://TURF-SAPI"))
                .route("user-sapi",
                        r -> r.path("/user-sapi/**")
                                .uri("lb://USER-SAPI"))
                .build();

    }

}
