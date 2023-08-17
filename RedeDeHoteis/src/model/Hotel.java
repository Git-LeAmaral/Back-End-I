package model;

import java.util.UUID;

public class Hotel {
    private String id;
    private String nomeDaFilial;
    private Avaliacao avaliacao;
    private String rua;
    private Integer numero;
    private String cidade;
    private String estado;

    public Hotel(String nomeDaFilial,
                 Avaliacao avaliacao,
                 String rua,
                 Integer numero, String cidade, String estado) {

        this.id = UUID.randomUUID().toString();;
        this.nomeDaFilial = nomeDaFilial;
        this.avaliacao = avaliacao;
        this.rua = rua;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Hotel(String id,
                 String nomeDaFilial,
                 Avaliacao avaliacao,
                 String rua,
                 Integer numero,
                 String cidade, String estado) {

        this.id = id;
        this.nomeDaFilial = nomeDaFilial;
        this.avaliacao = avaliacao;
        this.rua = rua;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomeDaFilial() {
        return nomeDaFilial;
    }

    public void setNomeDaFilial(String nomeDaFilial) {
        this.nomeDaFilial = nomeDaFilial;
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id='" + id + '\'' +
                ", nomeDaFilial='" + nomeDaFilial + '\'' +
                ", avaliacao=" + avaliacao +
                ", rua='" + rua + '\'' +
                ", numero=" + numero +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
