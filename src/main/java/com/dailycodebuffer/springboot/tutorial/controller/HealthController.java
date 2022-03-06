package com.dailycodebuffer.springboot.tutorial.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {
    @GetMapping("/")
    public String getHealth() {
        return "This server is up and running!";
    }
}
