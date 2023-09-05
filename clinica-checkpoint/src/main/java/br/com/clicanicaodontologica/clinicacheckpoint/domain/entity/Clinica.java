package br.com.clicanicaodontologica.clinicacheckpoint.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Clinica {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private  UUID id;

    @Column
    private String nome;

    @Column(length = 80)
    private String razaoSocial;

    private Instant createdAt;

    private Instant updateAt;

    @Column
    private String descricao;

    private Endereco endereco;

    private Contato contato;
}
