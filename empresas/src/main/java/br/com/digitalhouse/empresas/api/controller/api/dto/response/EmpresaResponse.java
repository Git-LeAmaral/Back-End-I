package br.com.digitalhouse.empresas.api.controller.api.dto.response;

import br.com.digitalhouse.empresas.api.controller.api.dto.request.ContatoRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class EmpresaResponse {
    private UUID id;
    private String nome;
    private String razaoSocial;
    private String cnpj;
    private ContatoResponse contato;
}
