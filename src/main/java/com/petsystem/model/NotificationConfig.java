package com.petsystem.model;

import jakarta.persistence.*;

@Entity
@Table(name = "notification_config")
public class NotificationConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String notificationEmail;
    private String whatsappPhoneNumber;
    private boolean notifyNewAppointment;
    private boolean notifyLowStock;
    private boolean notifyNewClient;

    // Construtor vazio (necessário para JPA)
    public NotificationConfig() {}

    // Getters and Setters...

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNotificationEmail() {
        return notificationEmail;
    }

    public void setNotificationEmail(String notificationEmail) {
        this.notificationEmail = notificationEmail;
    }

    public String getWhatsappPhoneNumber() {
        return whatsappPhoneNumber;
    }

    public void setWhatsappPhoneNumber(String whatsappPhoneNumber) {
        this.whatsappPhoneNumber = whatsappPhoneNumber;
    }

    public boolean isNotifyNewAppointment() {
        return notifyNewAppointment;
    }

    public void setNotifyNewAppointment(boolean notifyNewAppointment) {
        this.notifyNewAppointment = notifyNewAppointment;
    }

    public boolean isNotifyLowStock() {
        return notifyLowStock;
    }

    public void setNotifyLowStock(boolean notifyLowStock) {
        this.notifyLowStock = notifyLowStock;
    }

    public boolean isNotifyNewClient() {
        return notifyNewClient;
    }

    public void setNotifyNewClient(boolean notifyNewClient) {
        this.notifyNewClient = notifyNewClient;
    }
}