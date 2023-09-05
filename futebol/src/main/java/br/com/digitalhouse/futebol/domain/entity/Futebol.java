package br.com.digitalhouse.futebol.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
public class Futebol {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true)
    private String nome;
    private LocalDate dataEvento;

    public Futebol(String nome, LocalDate dataEvento) {
        this.nome = nome;
        this.dataEvento = dataEvento;
    }
}
