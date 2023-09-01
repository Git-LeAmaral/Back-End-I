package br.com.digitalhouse.clinica.domain.entity;

import lombok.Getter;

@Getter
public class Contato {
    private String telefone;
    private String email;

    public Contato(String telefone, String email) {
        this.telefone = telefone;
        this.email = email;
    }
}
