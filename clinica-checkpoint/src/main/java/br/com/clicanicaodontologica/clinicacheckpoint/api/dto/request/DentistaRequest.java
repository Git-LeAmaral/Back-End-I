package br.com.clicanicaodontologica.clinicacheckpoint.api.dto.request;

import br.com.clicanicaodontologica.clinicacheckpoint.domain.entity.Clinica;
import br.com.clicanicaodontologica.clinicacheckpoint.domain.entity.EspecialidadeEnum;
import br.com.clicanicaodontologica.clinicacheckpoint.domain.entity.GeneroEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.Set;

@Getter
@Setter
public class DentistaRequest {

    @NotBlank
    private String nome;
    @NotBlank
    private String cro;
    @NotNull
    private Instant dataNascimento;
    @NotNull
    private EspecialidadeEnum especialidadeEnum;
    @NotNull
    private GeneroEnum generoEnum;
    @NotNull
    private ContatoRequest contato;
    @NotEmpty
    private Set<Clinica> clinicasDentistas;
}
