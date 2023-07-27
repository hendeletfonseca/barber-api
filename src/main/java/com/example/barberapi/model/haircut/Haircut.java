package com.example.barberapi.model.haircut;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "haircuts")
@Entity(name = "haircut")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Haircut {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Long barberId;
    private String name;
    private Double price;
    private String description;

    public Haircut(HaircutRequestDTO data) {
        this.name = data.name();
        this.price = data.price();
        this.description = data.description();
        this.barberId = data.barberId();
    }

}
