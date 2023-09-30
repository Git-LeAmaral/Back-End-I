package br.com.clicanicaodontologica.clinicacheckpoint.api.dto.request;

import br.com.clicanicaodontologica.clinicacheckpoint.domain.entity.GeneroEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
@Getter
@Setter
public class PacienteRequest {

    @NotBlank
    private String nome;
    @NotNull
    private Instant dataNascimento;
    @NotNull
    private GeneroEnum genero;
    @NotNull
    private EnderecoRequest endereco;
    @NotNull
    private ContatoRequest contato;
}
