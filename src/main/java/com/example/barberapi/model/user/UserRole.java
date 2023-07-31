package com.example.barberapi.model.user;

public enum UserRole {
    ADMIN("admin"),
    CLIENT("client"),
    PARTNER("partner");

    private String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
