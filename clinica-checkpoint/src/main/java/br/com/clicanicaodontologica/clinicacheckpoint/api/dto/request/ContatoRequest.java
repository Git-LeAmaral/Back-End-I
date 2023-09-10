package br.com.clicanicaodontologica.clinicacheckpoint.api.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContatoRequest {

    private String email;
    private String telefone;
}
