package br.com.digitalhouse.apostas.domain.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
@Getter
@Setter
public class Equipe {
    private String id;
    private String nome;
    private String pais;
}
