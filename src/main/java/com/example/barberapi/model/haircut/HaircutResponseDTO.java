package com.example.barberapi.model.haircut;

public record HaircutResponseDTO(Long id, Long barberId, String name, Double price, String description) {
    public HaircutResponseDTO(Haircut haircut) {
        this(haircut.getId(), haircut.getBarberId(), haircut.getName(), haircut.getPrice(), haircut.getDescription());
    }
}
