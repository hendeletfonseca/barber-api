package com.example.barberapi.model.schedule;

import java.sql.Date;
import java.sql.Time;

public record ScheduleRequestDTO(Long barberId, Long userId, Date date, Time time, Long haircutId, String status) {
}
