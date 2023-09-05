package br.com.clicanicaodontologica.clinicacheckpoint.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDate;
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
    private Dentista dentista;
    private Clinica clinica;
    private LocalDate dataConsulta;
    private Instant createdAt;
    private Instant updateAt;
    @Column
    private String descricao;
    private Boolean cancelada;
    @Column(length = 80)
    private String motivoCancelamento;
}
