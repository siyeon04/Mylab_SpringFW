package com.mylab;

import org.springframework.stereotype.Component;

@Component
public class SecurityService {

    public boolean authenticate(String username) {
        System.out.println("[SecurityService] 인증 처리: " + username);
        return true;
    }
}