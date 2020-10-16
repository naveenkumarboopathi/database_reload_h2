package com.example.controller;

import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public ResponseEntity<?> fetchUsers(@RequestParam(value = "index", required = false) Integer pageNo, @RequestParam(value = "count", required = false) Integer pageSize) {
        return userService.fetchUsers(pageNo, pageSize);
    }

    @PostMapping("/user")
    public ResponseEntity<?> createUser(@RequestParam(value = "userName", required = false) String name) {
        return userService.createUser(name);
    }
}
