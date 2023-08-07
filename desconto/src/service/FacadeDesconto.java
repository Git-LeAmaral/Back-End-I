package service;

import model.Cartao;
import model.Produto;

public interface FacadeDesconto {

    int desconto(Cartao cartao, Produto produto, int quantidade);

}
