package br.com.digitalhouse.apostas.api.controller.dto.response;

import br.com.digitalhouse.apostas.api.controller.dto.EquipeDTO;
import br.com.digitalhouse.apostas.domain.entity.Equipe;
import br.com.digitalhouse.apostas.domain.entity.StatusEnum;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;
@Getter
@Setter
public class PartidaResponse {


    private String id;
    private String resultado;
    private StatusEnum status;
    private EquipeDTO local;
    private EquipeDTO visitante;
}
