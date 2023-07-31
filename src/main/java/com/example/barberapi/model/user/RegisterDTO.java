package com.example.barberapi.model.user;

public record RegisterDTO(String login, String password, UserRole role) {
}
