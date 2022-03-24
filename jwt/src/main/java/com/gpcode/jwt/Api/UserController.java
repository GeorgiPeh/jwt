package com.gpcode.jwt.Api;

import com.gpcode.jwt.Entity.User;
import com.gpcode.jwt.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api")
public class UserController {

    private final UserService userService;

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<User>>getAllUsers() {
        return ResponseEntity.ok().body(userService.getAllUsers());
    }
}
