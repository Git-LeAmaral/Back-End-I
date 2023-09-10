package br.com.clicanicaodontologica.clinicacheckpoint.api.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClinicaRequest {

    private String nome;
    private String cnpj;
    private String razaoSocial;
    private String descricao;
    private ContatoRequest contato;
    private EnderecoRequest endereco;
}
