package br.com.clicanicaodontologica.clinicacheckpoint.api.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class EnderecoResponse {

    private UUID id;
    private String logadouro;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
}
