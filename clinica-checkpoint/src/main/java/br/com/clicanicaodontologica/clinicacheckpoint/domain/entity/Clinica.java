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

    private String nome;

    @Column(nullable = false)
    private String cnpj;

    @Column(length = 80, nullable = false)
    private String razaoSocial;

    private Instant createdAt;

    private Instant updateAt;

    @Column
    private String descricao;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco",
        referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_endereco_clinica")
    )
    private Endereco endereco;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_contato",
            referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_contato_clinica")
    )
    private Contato contato;
}

