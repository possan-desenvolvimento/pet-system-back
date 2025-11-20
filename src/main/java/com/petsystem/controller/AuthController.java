package com.petsystem.controller;

import com.petsystem.dto.LoginRequestDto;
import com.petsystem.dto.UserRegistrationDto;
import com.petsystem.model.User;
import com.petsystem.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRegistrationDto registrationDto) {
        try {
            User registeredUser = userService.registerNewUser(registrationDto.getUsername(), registrationDto.getPassword());
            return new ResponseEntity<>("User registered successfully!", HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequestDto loginDTO) {
        Optional<User> userOptional = userService.findByUserName(loginDTO.getUsername());

        if (userOptional.isPresent()) {
            User user = userOptional.get();

            if (userService.checkPassword(loginDTO.getPassword(), user.getPassword())) {
                // Retornar um JSON válido
                return ResponseEntity.ok(Map.of(
//                        "message", "Login successful!",
//                        "username", user.getUsername()
                ));
            }
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of(
                "error", "Invalid username or password"
        ));
    }


}
