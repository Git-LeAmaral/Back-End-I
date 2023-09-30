package br.com.clicanicaodontologica.clinicacheckpoint.api.dto.request;

import br.com.clicanicaodontologica.clinicacheckpoint.domain.entity.Clinica;
import br.com.clicanicaodontologica.clinicacheckpoint.domain.entity.Dentista;
import br.com.clicanicaodontologica.clinicacheckpoint.domain.entity.Paciente;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
public class ConsultaRequest {

    @NotNull
    private Paciente paciente;
    @NotNull
    private Dentista dentista;
    @NotNull
    private Clinica clinica;
    @NotNull
    private Instant dataConsulta;
    @NotNull
    private String descricao;
    @NotNull
    private Boolean cancelada;
    private String motivoCancelamento;
}
