package com.company.demo.controller;

import com.company.demo.model.AlertPayload;
import org.springframework.web.bind.annotation.*;

@RestController
public class AlertsController {
//    @ResponseBody
    @PostMapping("/mock-endpoint")
    public String mockEndpoint(@RequestBody AlertPayload alertPayload) {
        // Simulate processing by printing the received data
        System.out.println("Received data:");
        System.out.println(alertPayload);

        // Respond with a simple JSON message
        return "{\"message\": \"Alert data received successfully\"}";

    }
    @GetMapping("/")
    public String demo(){
        return "Hello World";
    }
}

