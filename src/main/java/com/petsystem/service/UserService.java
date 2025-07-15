package com.petsystem.service;

import com.petsystem.model.User;
import com.petsystem.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public User registerNewUser(String username, String rawPassword) {
        if (userRepository.findByUsername(username).isPresent()) {
            throw  new RuntimeException("Username already exists!");
        }

        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(passwordEncoder.encode(rawPassword));

        return userRepository.save(newUser);
    }

    @Transactional(readOnly = true)
    public Optional<User> findByUserName(String username) {
        return userRepository.findByUsername(username);
    }

    public boolean checkPassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }



}
