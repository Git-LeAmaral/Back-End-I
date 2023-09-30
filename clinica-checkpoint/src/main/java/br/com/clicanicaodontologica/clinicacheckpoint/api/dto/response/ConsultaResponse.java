package br.com.clicanicaodontologica.clinicacheckpoint.api.dto.response;

import br.com.clicanicaodontologica.clinicacheckpoint.domain.entity.Dentista;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
public class ConsultaResponse {
    private UUID id;
    private UUID paciente;
    private UUID dentista;
    private UUID clinica;
    private Instant dataConsulta;
    private Instant createdAt;
    private Instant updatedAt;
    private String descricao;
    private Boolean cancelada;
    private String motivoCancelamento;
}
