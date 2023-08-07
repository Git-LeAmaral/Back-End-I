package service.impl;

import model.BancoEnum;
import model.Cartao;
import org.apache.log4j.Logger;

public class ApiCartao {

    public int desconto(Cartao cartao) {



        if (cartao.getBanco() == BancoEnum.STAR_BANK) {
            System.out.println("Cartão Star Bank ativo, desconto de 20");
            return 20;
        }
        return 0;
    }

}
