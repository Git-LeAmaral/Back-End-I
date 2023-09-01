package br.com.digitalhouse.clinica.domain.entity;

import lombok.Getter;

@Getter
public enum GeneroEnum {
    M("Masculino"),
    F("Feminino");

    private final String nome;

    GeneroEnum(String nome) {
        this.nome = nome;
    }
}
