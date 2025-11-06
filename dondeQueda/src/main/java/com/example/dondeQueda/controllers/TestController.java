package com.example.dondeQueda.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/para/luci")
    ResponseEntity<?> getMessage(){
        String message = "Luci me debes unas pizzas";
        return ResponseEntity.ok(message);
    }
}
