package br.com.digitalhouse.clinicaodontologica.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDate;

@Setter
@Getter
@Entity
public class Dentista {
    @Id
    @GeneratedValue()
    private Integer id;
    @Column(length = 80)
    private String nome;
    @Column(length = 80)
    private String sobrenome;
    @Column(length = 12, nullable = false)
    private String cro;
    private LocalDate dataNascimento;
    @Column(updatable = false)
    private Instant createdAt;
    private Instant updatedAt;

    @PrePersist
    public void naCriacao() {
        this.createdAt = Instant.now();
    }

    @PreUpdate
    public void naAtualizacao() {
        this.updatedAt = Instant.now();
    }
}
