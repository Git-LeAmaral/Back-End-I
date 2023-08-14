package model;

import java.util.UUID;

public class Hotel {
    private String id;
    private String nomeDaFilial;
    private Endereco endereco;
    private Avaliacao avaliacao;

    public Hotel(String nomeDaFilial, Endereco endereco, Avaliacao avaliacao) {
        this.id = UUID.randomUUID().toString();
        this.nomeDaFilial = nomeDaFilial;
        this.endereco = endereco;
        this.avaliacao = avaliacao;
    }

    public Hotel(String id, String nomeDaFilial, Endereco endereco, Avaliacao avaliacao) {
        this.id = id;
        this.nomeDaFilial = nomeDaFilial;
        this.endereco = endereco;
        this.avaliacao = avaliacao;
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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", nomeDaFilial='" + nomeDaFilial + '\'' +
                ", endereco=" + endereco +
                ", avaliacao=" + avaliacao +
                '}';
    }
}
