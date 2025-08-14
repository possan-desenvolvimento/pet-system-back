package com.petsystem.repository;

import com.petsystem.model.NotificationConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NotificationConfigRepository extends JpaRepository<NotificationConfig, Long> {
    // Busca a única configuração de notificação.
    // Usamos Optional pois pode não existir no banco.
    Optional<NotificationConfig> findFirstBy();
}