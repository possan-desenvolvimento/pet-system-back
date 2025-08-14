package com.petsystem.repository;

import com.petsystem.model.UserPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserPermissionRepository extends JpaRepository<UserPermission, Long> {
    // Método para encontrar todas as permissões de um usuário específico
    List<UserPermission> findByUserId(Long userId);

    // Método para deletar todas as permissões de um usuário
    void deleteByUserId(Long userId);
}