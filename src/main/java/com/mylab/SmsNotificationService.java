package com.mylab;

public class SmsNotificationService implements NotificationService {

    private String provider;

    // Constructor 인젝션
    public SmsNotificationService(String provider) {
        this.provider = provider;
    }

    public String getProvider() {
        return provider;
    }

    @Override
    public void sendNotification(String message) {
        System.out.println("[SMS] 메시지: " + message + " / 제공업체: " + provider);
    }
}