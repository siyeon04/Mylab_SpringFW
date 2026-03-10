package com.mylab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SecurityService securityService;

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public SecurityService getSecurityService() {
        return securityService;
    }

    public boolean registerUser(String username) {
        System.out.println("[UserService] 사용자 등록 시작: " + username);
        boolean authenticated = securityService.authenticate(username);
        if (authenticated) {
            userRepository.save(username);
            System.out.println("[UserService] 사용자 등록 완료: " + username);
            return true;
        }
        return false;
    }
}