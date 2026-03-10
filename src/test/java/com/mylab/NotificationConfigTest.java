package com.mylab;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(classes = NotificationConfig.class)
public class NotificationConfigTest {

    @Autowired
    private NotificationManager notificationManager;

    @Test
    void testNotificationManager() {
        // 1. NotificationManager가 Null이 아닌지 검증
        assertNotNull(notificationManager, "notificationManager가 null이면 안 됩니다.");

        // 2. 이메일 서비스 검증
        assertNotNull(notificationManager.getEmailService(),
                "emailService가 null이면 안 됩니다.");

        EmailNotificationService emailService =
                (EmailNotificationService) notificationManager.getEmailService();

        assertEquals("smtp.gmail.com", emailService.getSmtpServer(),
                "smtpServer는 smtp.gmail.com이어야 합니다.");
        assertEquals(587, emailService.getPort(),
                "port는 587이어야 합니다.");

        // 3. SMS 서비스 검증
        assertNotNull(notificationManager.getSmsService(),
                "smsService가 null이면 안 됩니다.");

        SmsNotificationService smsService =
                (SmsNotificationService) notificationManager.getSmsService();

        assertEquals("SKT", smsService.getProvider(),
                "provider는 SKT이어야 합니다.");

        // 4. NotificationManager 메서드 실행
        assertDoesNotThrow(() -> notificationManager.sendNotificationByEmail("테스트 이메일"));
        assertDoesNotThrow(() -> notificationManager.sendNotificationBySms("테스트 SMS"));
    }
}