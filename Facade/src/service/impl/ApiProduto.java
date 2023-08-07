package service.impl;

import model.Produto;

public class ApiProduto {

    public int desconto(Produto produto) {
        if (produto.getTipo() == "Lata") {
            System.out.println("Produto enlatado, desconto de 10");
            return 10;
        }
        return 0;
    }
}
