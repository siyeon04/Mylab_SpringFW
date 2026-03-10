package com.mylab;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(locations = "classpath:mylab-user-di.xml")
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void testUserService() {
        // 1. UserService가 Null이 아닌지 검증
        assertNotNull(userService, "userService Bean이 null이면 안 됩니다.");

        // 2. userService.getUserRepository() 가 Not Null 인지 검증
        assertNotNull(userService.getUserRepository(),
                "userRepository가 null이면 안 됩니다.");

        // 3. userRepository의 dbType 값이 "MySQL" 인지 검증
        assertEquals("MySQL", userService.getUserRepository().getDbType(),
                "dbType은 MySQL이어야 합니다.");

        // 4. userService.getSecurityService() 가 Not Null 인지 검증
        assertNotNull(userService.getSecurityService(),
                "securityService가 null이면 안 됩니다.");

        // 5. registerUser() 메서드가 true 인지 검증
        assertTrue(userService.registerUser("홍길동"),
                "registerUser()는 true를 반환해야 합니다.");
    }
}