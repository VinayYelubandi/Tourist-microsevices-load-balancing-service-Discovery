package com.example.tourist;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TouristController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/tourists")
    public String getTourists() {
        return "Welcome to Smart Tourism Portal! Tourist Service running on port: " + port;
    }

    @GetMapping("/tourists/places")
    public String getPlaces() {
        return "Tourist Places: Tirupati, Goa, Hyderabad, Visakhapatnam. Served by port: " + port;
    }
}
