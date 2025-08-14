package com.petsystem.service;

import com.petsystem.model.UserConfig;
import com.petsystem.repository.UserConfigRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserConfigService {

    private final UserConfigRepository repository;

    public UserConfigService(UserConfigRepository repository) {
        this.repository = repository;
    }

    public List<UserConfig> findAll() {
        return repository.findAll();
    }

    public UserConfig save(UserConfig userConfig) {
        return repository.save(userConfig);
    }
}
