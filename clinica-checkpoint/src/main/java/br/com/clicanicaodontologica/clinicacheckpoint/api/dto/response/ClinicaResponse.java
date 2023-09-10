package br.com.clicanicaodontologica.clinicacheckpoint.api.dto.response;

import br.com.clicanicaodontologica.clinicacheckpoint.domain.entity.Contato;
import br.com.clicanicaodontologica.clinicacheckpoint.domain.entity.Endereco;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
public class ClinicaResponse {
    private UUID id;
    private String nome;
    private String cnpj;
    private String razaoSocial;
    private Instant createdAt;
    private Instant updateAt;
    private String descricao;
    private Endereco endereco;
    private Contato contato;
}
