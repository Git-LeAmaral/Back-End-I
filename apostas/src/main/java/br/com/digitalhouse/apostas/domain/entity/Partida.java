package br.com.digitalhouse.apostas.domain.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
@Getter
@Setter
@Document("partida")
public class Partida {

    @Id
    private String id;
    private String resultado;
    private StatusEnum status;
    @Field(name = "equipe_local")
    private Equipe local;
    @Field(name = "equipe_visitante")
    private Equipe visitante;
}
