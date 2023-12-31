package br.com.clicanicaodontologica.clinicacheckpoint.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "enderecos")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="id")
    private UUID id;

    @Column(length = 100)
    private String logadouro;

    @Column(length = 100)
    private String bairro;

    private Instant createdAt;

    private Instant updateAt;

    @Column(length = 100)
    private String cidade;

    @Column(length = 100)
    private String estado;

    @Column(length = 10)
    private String cep;
}
