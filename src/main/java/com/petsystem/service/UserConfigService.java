package com.petsystem.service;

import com.petsystem.model.UserConfig;
import com.petsystem.repository.UserConfigRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    // Adicionado: Método para encontrar um usuário pelo ID
    public Optional<UserConfig> findById(Long id) {
        return repository.findById(id);
    }

    // Adicionado: Método para deletar um usuário pelo ID
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}