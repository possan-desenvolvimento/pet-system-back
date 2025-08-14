package com.petsystem.controller;

import com.petsystem.model.NotificationConfig;
import com.petsystem.service.NotificationConfigService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notifications")
@CrossOrigin(origins = "*") // Permite requisições do front-end
public class NotificationConfigController {

    private final NotificationConfigService service;

    public NotificationConfigController(NotificationConfigService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<NotificationConfig> getNotificationsConfig() {
        NotificationConfig config = service.getNotificationConfig();
        return ResponseEntity.ok(config);
    }

    @PutMapping
    public ResponseEntity<NotificationConfig> updateNotificationsConfig(@RequestBody NotificationConfig config) {
        NotificationConfig updatedConfig = service.updateNotificationConfig(config);
        return ResponseEntity.ok(updatedConfig);
    }
}