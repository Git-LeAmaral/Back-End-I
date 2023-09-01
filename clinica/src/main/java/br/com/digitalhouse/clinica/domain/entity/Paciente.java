package br.com.digitalhouse.clinica.domain.entity;

import lombok.Getter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
public class Paciente {

    private UUID id;
    private String nome;
    private String sobrenome;
    private String documento;
    private LocalDate dataNacimento;
    private Contato contato;
    private GeneroEnum genero;

    private Paciente(UUID id, String nome,
                    String sobrenome,
                    String documento,
                    LocalDate dataNacimento,
                    Contato contato,
                     GeneroEnum genero) {

        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.dataNacimento = dataNacimento;
        this.contato = contato;
        this.genero = genero;
        validar();
    }

    public static Paciente novoPaciente(String nome,
                                        String sobrenome,
                                        String documento,
                                        LocalDate dataNacimento,
                                        Contato contato,
                                        GeneroEnum genero) {

        UUID idPaciente = UUID.randomUUID();
        return new Paciente(idPaciente, nome, sobrenome, documento, dataNacimento,
                contato, genero);

    }

    private void validar() {
        if (nome == null) {
            throw new IllegalArgumentException("'nome' não informado!");
        }
    }
}
