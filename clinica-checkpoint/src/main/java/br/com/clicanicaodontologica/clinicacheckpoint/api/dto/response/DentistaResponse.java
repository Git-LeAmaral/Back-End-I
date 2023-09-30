package br.com.clicanicaodontologica.clinicacheckpoint.api.dto.response;

import br.com.clicanicaodontologica.clinicacheckpoint.api.dto.request.ContatoRequest;
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
import java.util.UUID;

@Getter
@Setter
public class DentistaResponse {

    private UUID id;
    private String nome;
    private String cro;
    private Instant dataNascimento;
    private EspecialidadeEnum especialidadeEnum;
    private GeneroEnum generoEnum;
    private Instant createdAt;
    private Instant updatedAt;
    private ContatoResponse contato;
    private Set<Clinica> clinicasDentistas;
}
