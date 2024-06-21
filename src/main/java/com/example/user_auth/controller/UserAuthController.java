package com.example.user_auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAuthController {

    @GetMapping("/test/1")
    public String testApi() {
        return "Test API 1";
    }

}
