package model;

public class Cartao {
    private String numero;
    private BancoEnum banco;

    public Cartao(String numero, BancoEnum banco) {
        this.numero = numero;
        this.banco = banco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public BancoEnum getBanco() {
        return banco;
    }

    public void setBanco(BancoEnum banco) {
        this.banco = banco;
    }
}
