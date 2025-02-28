package com.CircuitBreaker.controller;

import com.CircuitBreaker.service.BackendService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoController {

    private final BackendService backendService;

    public DemoController(BackendService backendService) {
        this.backendService = backendService;
    }

    @GetMapping("/data")
    @CircuitBreaker(name = "myService", fallbackMethod = "fallbackResponse")
    public String fetchData() {
        return backendService.getDataFromRemoteService();
    }

    public String fallbackResponse(Exception e) {
        return "Fallback response: Service is currently unavailable";
    }
}