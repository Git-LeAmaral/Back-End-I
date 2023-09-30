package br.com.clicanicaodontologica.clinicacheckpoint.api.dto.response.list;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
public class ConsultaListResponse {
    private UUID id;
    private Instant dataConsulta;
}
