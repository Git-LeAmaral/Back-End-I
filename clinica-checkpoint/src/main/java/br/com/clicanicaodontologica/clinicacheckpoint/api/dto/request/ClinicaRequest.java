package br.com.clicanicaodontologica.clinicacheckpoint.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;

@Getter
@Setter
public class ClinicaRequest {
    @NotBlank
    private String nome;
    @NotBlank
    @CNPJ
    private String cnpj;
    @NotBlank
    private String razaoSocial;
    @NotBlank
    private String descricao;
    @NotNull
    private ContatoRequest contato;
    @NotNull
    private EnderecoRequest endereco;
}
