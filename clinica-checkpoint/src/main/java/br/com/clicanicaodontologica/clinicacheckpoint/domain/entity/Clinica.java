package br.com.clicanicaodontologica.clinicacheckpoint.domain.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@ToString
@Table(name = "clinicas")
public class Clinica {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private  UUID id;

    private String nome;

    @Column(nullable = false)
    private String cnpj;

    @Column(length = 80, nullable = false)
    private String razaoSocial;

    private Instant createdAt;

    private Instant updatedAt;

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

    @PrePersist
    public void criando() {
        this.createdAt = Instant.now();
    }

    @PreUpdate
    public void atualizando() {
        this.updatedAt = Instant.now();
    }

}

