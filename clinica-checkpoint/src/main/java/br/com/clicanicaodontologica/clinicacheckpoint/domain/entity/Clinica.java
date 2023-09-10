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

    @ManyToMany
    @JoinTable(
            name = "clinicaDentistas",
            joinColumns = @JoinColumn(name = "id_dentista"),
            inverseJoinColumns = @JoinColumn(name = "id_")
    )
    private String nome;

    @Column(nullable = false)
    private String cnpj;

    @Column(length = 80, nullable = false)
    private String razaoSocial;

    private Instant createdAt;

    private Instant updateAt;

    @Column
    private String descricao;

    private Endereco endereco;

    private Contato contato;
}

