package com.CircuitBreaker.service;

import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class BackendService {

    public String getDataFromRemoteService() {
        if (new Random().nextBoolean()) { // Simulating random failures
            throw new RuntimeException("Service is down");
        }
        return "Data from remote service";
    }
}