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
            joinColumns = @JoinColumn(name = "id_dentista"),
            inverseJoinColumns = @JoinColumn(name = "id_clinica"))
    private Set<Consulta> consultas;
}
