package br.com.digitalhouse.veiculos.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class Veiculo implements Serializable {

    private Integer id;
    private MarcaEnum marca;
    private String nome;
    private String cor;
    private Integer placa;

    @Override
    public String toString() {
        return "Veiculo{" +
                "id=" + id +
                ", marca=" + marca +
                ", nome='" + nome + '\'' +
                ", cor='" + cor + '\'' +
                ", placa=" + placa +
                '}';
    }
}
