package br.com.clicanicaodontologica.clinicacheckpoint.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "consultas")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private Paciente paciente;
    private Clinica clinica;
    private Instant dataConsulta;
    private Instant createdAt;
    private Instant updatedAt;
    private String descricao;
    private Boolean cancelada;
    @Column(length = 80)
    private String motivoCancelamento;
}
