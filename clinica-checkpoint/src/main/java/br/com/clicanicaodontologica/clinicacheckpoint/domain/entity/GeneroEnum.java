package br.com.clicanicaodontologica.clinicacheckpoint.domain.entity;

public enum GeneroEnum {
    M("Masculino"), F("Feminino");

    private String genero;
    GeneroEnum(String genero) {
        this.genero = genero;
    }

    public String getGenero(){
        return genero;
    }
}
