package com.petsystem.controller;

import com.petsystem.service.UserPermissionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/permissions")
@CrossOrigin(origins = "*") // Permite requisições do front-end
public class UserPermissionController {

    private final UserPermissionService service;

    public UserPermissionController(UserPermissionService service) {
        this.service = service;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Set<String>> getPermissions(@PathVariable Long userId) {
        Set<String> permissions = service.getPermissionsByUserId(userId);
        return ResponseEntity.ok(permissions);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<Void> updatePermissions(@PathVariable Long userId, @RequestBody Set<String> permissions) {
        service.updatePermissions(userId, permissions);
        return ResponseEntity.ok().build();
    }
}