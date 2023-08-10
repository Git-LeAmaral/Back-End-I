package model;

import java.util.UUID;

public class Conta {

    private String id;
    private String nome;
    private String numero;
    private int saldo;

    public Conta(String id, String nome, String numero, int saldo) {
        this.id = id;
        this.nome = nome;
        this.numero = numero;
        this.saldo = saldo;
    }

    public Conta(String nome, String numero, int saldo) {
        this.id = UUID.randomUUID().toString();
        this.nome = nome;
        this.numero = numero;
        this.saldo = saldo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", numero='" + numero + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}
