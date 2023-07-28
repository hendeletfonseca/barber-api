package com.example.barberapi.model.schedule;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;

@Table(name = "schedules")
@Entity(name = "schedule")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Schedule {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Long barberId;
    private Long userId;
    private Date date;
    private Time time;
    private Long haircutId;
    private String status;

    public Schedule(ScheduleRequestDTO data) {
        this.barberId = data.barberId();
        this.userId = data.userId();
        this.date = data.date();
        this.time = data.time();
        this.haircutId = data.haircutId();
        this.status = data.status();
    }
}
