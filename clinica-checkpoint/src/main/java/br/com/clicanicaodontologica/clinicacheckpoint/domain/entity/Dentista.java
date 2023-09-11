package br.com.clicanicaodontologica.clinicacheckpoint.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "dentistas")
public class Dentista {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String cro;
    private String nome;
    private Instant dataNascimento;
    private EspecialidadeEnum especialidadeEnum;
    private Instant createdAt;
    private Instant updatedAt;
    private GeneroEnum generoEnum;
    private Contato contato;
    private Endereco endereco;
    private Set<Consulta> consultas;
}
