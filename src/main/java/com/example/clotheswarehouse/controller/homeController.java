package com.example.clotheswarehouse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/home")
public class homeController {
    @GetMapping
    public String home() {
        return "home";
    }
}
