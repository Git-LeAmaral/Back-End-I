package br.com.digitalhouse.apostas.api.controller.dto.request;

import br.com.digitalhouse.apostas.api.controller.dto.EquipeDTO;
import br.com.digitalhouse.apostas.domain.entity.Equipe;
import br.com.digitalhouse.apostas.domain.entity.StatusEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PartidaRequest {

    private String id;
    private String resultado;
    private StatusEnum status;
    private EquipeDTO local;
    private EquipeDTO visitante;
}
