package br.com.clicanicaodontologica.clinicacheckpoint.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "contatos")
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="id")
    private UUID id;

    @Column(length = 100)
    @Email
    private String email;

    @Column(length = 15)
    private String telefone;

    private Instant createdAt;

    private Instant updatedAt;

    @PrePersist
    public void criando() {
        this.createdAt = Instant.now();
    }

    @PreUpdate
    public void atualizando() {
        this.updatedAt = Instant.now();
    }

}
