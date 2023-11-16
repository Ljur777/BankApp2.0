package com.example.bankapp.entity.enums;

import org.springframework.security.core.GrantedAuthority;

public enum ClientStatus implements GrantedAuthority {
    ACTIVE,
    BLOCKED,
    ARCHIVED;

    @Override
    public String getAuthority() {
        return name(); //назва статусу, що привожу до String
    }
}
