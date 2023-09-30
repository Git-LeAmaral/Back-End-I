package br.com.clicanicaodontologica.clinicacheckpoint.api.dto.response.wrapper;

import br.com.clicanicaodontologica.clinicacheckpoint.api.dto.response.list.DentistaListResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class DentistaWrapperResponse {
    private List<DentistaListResponse> dentistas;
}
