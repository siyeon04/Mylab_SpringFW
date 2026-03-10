package com.mylab;

import org.springframework.stereotype.Component;

@Component
public class UserRepository {

    private String dbType = "MySQL";

    public String getDbType() {
        return dbType;
    }

    public void save(String username) {
        System.out.println("[UserRepository] 사용자 저장: " + username + " (DB: " + dbType + ")");
    }
}