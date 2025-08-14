package com.petsystem.service;

import com.petsystem.model.UserPermission;
import com.petsystem.repository.UserPermissionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserPermissionService {

    private final UserPermissionRepository repository;

    public UserPermissionService(UserPermissionRepository repository) {
        this.repository = repository;
    }

    public Set<String> getPermissionsByUserId(Long userId) {
        return repository.findByUserId(userId).stream()
                .map(UserPermission::getPermission)
                .collect(Collectors.toSet());
    }

    @Transactional
    public void updatePermissions(Long userId, Set<String> newPermissions) {
        // 1. Remova todas as permissões existentes para o usuário
        repository.deleteByUserId(userId);

        // 2. Crie e salve as novas permissões
        List<UserPermission> permissionsToSave = newPermissions.stream()
                .map(p -> new UserPermission(userId, p))
                .collect(Collectors.toList());

        repository.saveAll(permissionsToSave);
    }
}