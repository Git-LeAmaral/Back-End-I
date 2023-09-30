package br.com.clicanicaodontologica.clinicacheckpoint.api.dto.response.wrapper;

import br.com.clicanicaodontologica.clinicacheckpoint.api.dto.response.list.PacienteListResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PacienteWrapperResponse {
    List<PacienteListResponse> pacientes;
}
