package service.impl;

import model.Produto;

public class ApiProduto {
    //DESCONTO COM BASE NA API DE PRODUTO, SE LATA LOGO 10
    public int desconto(Produto produto) {
        if (produto.getTipo() == "Lata") {
            System.out.println("Produto enlatado, desconto de 10");
            return 10;
        }
        return 0;
    }
}
