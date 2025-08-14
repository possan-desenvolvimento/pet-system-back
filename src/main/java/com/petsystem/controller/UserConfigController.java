package com.petsystem.controller;

import com.petsystem.model.UserConfig;
import com.petsystem.service.UserConfigService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping
    public UserConfig create(@RequestBody UserConfig userConfig) {
        return service.save(userConfig);
    }



}
