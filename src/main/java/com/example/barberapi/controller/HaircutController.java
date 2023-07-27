package com.example.barberapi.controller;

import com.example.barberapi.model.haircut.Haircut;
import com.example.barberapi.model.haircut.HaircutRepository;
import com.example.barberapi.model.haircut.HaircutRequestDTO;
import com.example.barberapi.model.haircut.HaircutResponseDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("haircut")
public class HaircutController {
    @Autowired
    private HaircutRepository repository;

    @PostMapping
    public void saveHaircut(@RequestBody HaircutRequestDTO data) {
        Haircut haircut = new Haircut(data);
        repository.save(haircut);
    }

    @DeleteMapping("{id}")
    public void deleteHaircut(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @GetMapping
    public List<HaircutResponseDTO> getAll(){
        return repository.findAll().stream().map(HaircutResponseDTO::new).toList();
    }

    @GetMapping("{id}")
    public HaircutResponseDTO getHaircut(@PathVariable Long id) {
        Optional<Haircut> optionalHaircut = repository.findById(id);
        if (optionalHaircut.isPresent()) {
            return new HaircutResponseDTO(optionalHaircut.get());
        }
        throw new EntityNotFoundException();
    }


    @PutMapping("{id}")
public void updateHaircut(@PathVariable Long id, @RequestBody HaircutRequestDTO data) {
        Optional<Haircut> optionalHaircut = repository.findById(id);
        if (optionalHaircut.isPresent()) {
            Haircut haircut = optionalHaircut.get();
            haircut.setName(data.name());
            haircut.setPrice(data.price());
            haircut.setDescription(data.description());
            repository.save(haircut);
        }
    }
}
