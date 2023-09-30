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
    @Column(name = "id")
    private UUID id;
    private String cro;
    private String nome;
    private Instant dataNascimento;
    private EspecialidadeEnum especialidadeEnum;
    private Instant createdAt;
    private Instant updatedAt;
    private GeneroEnum generoEnum;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_contato" ,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_contato_dentista"))
    private Contato contato;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco" ,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_endereco_dentista"))
    private Endereco endereco;
    @ManyToMany
    @JoinTable(
            name = "clinicaDentista",
            joinColumns = @JoinColumn(name = "id_dentista",
                    foreignKey = @ForeignKey(name = "fk_dentista_clinica")),
            inverseJoinColumns = @JoinColumn(name = "id_clinica",
                    foreignKey = @ForeignKey(name = "fk_clinica_dentista")))
    private Set<Clinica> clinicasDentistas;

    @PrePersist
    public void criando() {
        this.createdAt = Instant.now();
    }

    @PreUpdate
    public void atualizando() {
        this.updatedAt = Instant.now();
    }
}
