package org.example.model;

public class LinguagemModel {

    private String tipo;
    private Boolean serOrientadaAObjeto;

    public LinguagemModel(String tipo, Boolean serOrientadaAObjeto) {
        this.tipo = tipo;
        this.serOrientadaAObjeto = serOrientadaAObjeto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Boolean getSerOrientadaAObjeto() {
        return serOrientadaAObjeto;
    }

    public void setSerOrientadaAObjeto(Boolean serOrientadaAObjeto) {
        this.serOrientadaAObjeto = serOrientadaAObjeto;
    }
}
