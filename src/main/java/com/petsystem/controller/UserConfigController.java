package com.petsystem.controller;

import com.petsystem.model.UserConfig;
import com.petsystem.service.UserConfigService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user-config")
@CrossOrigin(origins = "*")
public class UserConfigController {

    private final UserConfigService service;

    public UserConfigController(UserConfigService service) {
        this.service = service;
    }

    @GetMapping
    public List<UserConfig> getAll() {
        return service.findAll();
    }

    // ADICIONADO: Endpoint para buscar um único usuário pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<UserConfig> getById(@PathVariable Long id) {
        Optional<UserConfig> user = service.findById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public UserConfig create(@RequestBody UserConfig userConfig) {
        return service.save(userConfig);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserConfig> update(@PathVariable Long id, @RequestBody UserConfig userConfig) {
        Optional<UserConfig> existingUser = service.findById(id);

        if (existingUser.isPresent()) {
            UserConfig updatedUser = existingUser.get();
            updatedUser.setName(userConfig.getName());
            updatedUser.setEmail(userConfig.getEmail());
            updatedUser.setRole(userConfig.getRole());
            updatedUser.setPassword(userConfig.getPassword());

            return ResponseEntity.ok(service.save(updatedUser));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }
}