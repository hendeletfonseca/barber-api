package com.example.barberapi.controller;

import com.example.barberapi.model.schedule.Schedule;
import com.example.barberapi.model.schedule.ScheduleRepository;
import com.example.barberapi.model.schedule.ScheduleRequestDTO;
import com.example.barberapi.model.schedule.ScheduleResponseDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("schedule")
public class ScheduleController {
    @Autowired
    private ScheduleRepository repository;

    @PostMapping
    public void saveSchedule(@RequestBody ScheduleRequestDTO data) {
        Schedule schedule = new Schedule(data);
        repository.save(schedule);
    }

    @DeleteMapping("{id}")
    public void deleteSchedule(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @GetMapping
    public List<ScheduleResponseDTO> getAll() {
        return repository.findAll().stream().map(ScheduleResponseDTO::new).toList();
    }

    @GetMapping("{id}")
    public ScheduleResponseDTO getSchedule(@PathVariable Long id) {
        Optional<Schedule> optionalSchedule = repository.findById(id);
        if (optionalSchedule.isPresent()) {
            return new ScheduleResponseDTO(optionalSchedule.get());
        }
        throw new EntityNotFoundException();
    }

    @PutMapping("{id}")
    public void updateSchedule(@PathVariable Long id, @RequestBody ScheduleRequestDTO data) {
        Optional<Schedule> optionalSchedule = repository.findById(id);
        if (optionalSchedule.isPresent()) {
            Schedule schedule = optionalSchedule.get();
            schedule.setHaircutId(data.haircutId());
            schedule.setDate(data.date());
            schedule.setTime(data.time());
            schedule.setStatus(data.status());
            repository.save(schedule);
        }
    }
}
