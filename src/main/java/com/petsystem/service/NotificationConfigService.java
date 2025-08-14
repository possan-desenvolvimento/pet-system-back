package com.petsystem.service;

import com.petsystem.model.NotificationConfig;
import com.petsystem.repository.NotificationConfigRepository;
import org.springframework.stereotype.Service;

@Service
public class NotificationConfigService {

    private final NotificationConfigRepository repository;

    public NotificationConfigService(NotificationConfigRepository repository) {
        this.repository = repository;
    }

    public NotificationConfig getNotificationConfig() {
        return repository.findFirstBy().orElseGet(() -> {
            // Se não houver configuração, cria uma padrão
            NotificationConfig defaultConfig = new NotificationConfig();
            defaultConfig.setNotificationEmail("alertas@dvjpet.com.br");
            defaultConfig.setWhatsappPhoneNumber(""); // Inicia sem número
            defaultConfig.setNotifyNewAppointment(true);
            defaultConfig.setNotifyLowStock(true);
            defaultConfig.setNotifyNewClient(false);
            return repository.save(defaultConfig);
        });
    }

    public NotificationConfig updateNotificationConfig(NotificationConfig updatedConfig) {
        // Assume que sempre haverá apenas uma configuração para o sistema
        NotificationConfig existingConfig = repository.findFirstBy().orElse(new NotificationConfig());

        existingConfig.setNotificationEmail(updatedConfig.getNotificationEmail());
        existingConfig.setWhatsappPhoneNumber(updatedConfig.getWhatsappPhoneNumber());
        existingConfig.setNotifyNewAppointment(updatedConfig.isNotifyNewAppointment());
        existingConfig.setNotifyLowStock(updatedConfig.isNotifyLowStock());
        existingConfig.setNotifyNewClient(updatedConfig.isNotifyNewClient());

        return repository.save(existingConfig);
    }
}