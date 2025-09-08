package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Hello from HomeController!";
    }

    @GetMapping("/about")
    public String about() {
        return "This is the About page.";
    }
}
