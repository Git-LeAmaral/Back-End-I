package service.impl;

import model.BancoEnum;
import model.Cartao;

public class ApiCartao {

    //DESCONTO COM BASE NA API DE CARTAO, SE STAR_BANK LOGO 20
    public int desconto(Cartao cartao) {
        if (cartao.getBanco() == BancoEnum.STAR_BANK) {
            System.out.println("Cartão starbank ativo, desconto de 20");
            return 20;
        }
        return 0;
    }
}
