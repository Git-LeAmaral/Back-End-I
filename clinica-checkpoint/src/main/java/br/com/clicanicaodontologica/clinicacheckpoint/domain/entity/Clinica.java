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
@Table(name = "clinicas")
public class Clinica {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private  UUID id;

    @ManyToMany
    @JoinTable(
            name = "clinicaDentistas",
            joinColumns = @JoinColumn(name = "id_dentista"),
            inverseJoinColumns = @JoinColumn(name = "id_"),
            foreignKey = @ForeignKey(name = "fk_clinica_dentista")
    )
    private Set<Dentista> clinicaDentista;
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

