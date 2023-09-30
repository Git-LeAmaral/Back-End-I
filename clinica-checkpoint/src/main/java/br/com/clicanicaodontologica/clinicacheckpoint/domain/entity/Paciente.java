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
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="id")
    private UUID id;

    @Column(length = 80, nullable = false)
    private String nome;

    private Instant dataNascimento;

    private Instant createdAt;

    private Instant updatedAt;

    @Column(length = 1)
    private GeneroEnum generoEnum;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco",
            referencedColumnName = "id", foreignKey =
    @ForeignKey(name = "fk_endereco_paciente"))
    private Endereco endereco;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_contato",
            referencedColumnName = "id", foreignKey =
    @ForeignKey(name = "fk_contato_paciente"))
    private Contato contato;

}
