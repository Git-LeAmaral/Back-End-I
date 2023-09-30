package br.com.clicanicaodontologica.clinicacheckpoint.api.dto.response;

import br.com.clicanicaodontologica.clinicacheckpoint.api.dto.request.ContatoRequest;
import br.com.clicanicaodontologica.clinicacheckpoint.api.dto.request.EnderecoRequest;
import br.com.clicanicaodontologica.clinicacheckpoint.domain.entity.GeneroEnum;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
public class PacienteResponse {

    private UUID id;
    private String nome;
    private Instant dataNascimento;
    private GeneroEnum genero;
    private Instant createdAt;
    private Instant updatedAt;
    private EnderecoResponse endereco;
    private ContatoResponse contato;
}
