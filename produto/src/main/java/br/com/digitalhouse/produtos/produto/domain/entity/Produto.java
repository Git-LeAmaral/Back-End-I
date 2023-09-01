package br.com.digitalhouse.produtos.produto.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Produto {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(length = 60)
    private String nome;
    private Integer quantidade;
    private String Descricao;
}
