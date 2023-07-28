package com.example.barberapi.model.schedule;

public record ScheduleResponseDTO(Long id, Long barberId, Long userId, String date, Long haircutId, String status) {
    public ScheduleResponseDTO(Schedule schedule) {
        this(schedule.getId(), schedule.getBarberId(), schedule.getUserId(), schedule.getDate().toString(), schedule.getHaircutId(), schedule.getStatus());
    }
}