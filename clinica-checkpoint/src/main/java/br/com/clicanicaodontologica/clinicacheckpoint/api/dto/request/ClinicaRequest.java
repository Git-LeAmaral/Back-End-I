package br.com.clicanicaodontologica.clinicacheckpoint.api.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;

@Getter
@Setter
public class ClinicaRequest {

    private String nome;
    @CNPJ
    private String cnpj;
    private String razaoSocial;
    private String descricao;
    private ContatoRequest contato;
    private EnderecoRequest endereco;
}
