package br.com.clicanicaodontologica.clinicacheckpoint.api.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoRequest {

    private String logadouro;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
}
