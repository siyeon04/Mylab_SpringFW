package com.mylab;

public class EmailNotificationService implements NotificationService {

    private String smtpServer;
    private int port;

    // Constructor 인젝션
    public EmailNotificationService(String smtpServer, int port) {
        this.smtpServer = smtpServer;
        this.port = port;
    }

    public String getSmtpServer() {
        return smtpServer;
    }

    public int getPort() {
        return port;
    }

    @Override
    public void sendNotification(String message) {
        System.out.println("[Email] 메시지: " + message
                + " / SMTP: " + smtpServer + " / Port: " + port);
    }
}