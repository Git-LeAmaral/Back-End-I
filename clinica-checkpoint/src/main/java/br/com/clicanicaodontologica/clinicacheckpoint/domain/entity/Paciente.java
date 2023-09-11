package br.com.clicanicaodontologica.clinicacheckpoint.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(length = 80, nullable = false)
    private String nome;

    private Instant dataNascimento;

    private Instant createdAt;

    private Instant updatedAt;

    @Column(length = 1)
    private GeneroEnum generoEnum;

    private Endereco endereco;

    private Contato contato;
    private Set<Consulta> consultas;

}
