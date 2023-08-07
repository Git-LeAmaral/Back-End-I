package service.impl;

public class ApiQuantidade {

    public int desconto(int quantidade) {
        //return  quantidade >= 12 ? 15 : 0;

        if (quantidade >= 12) {
            System.out.println("Quantidade maior que 12, desconto de 15");
            return 15;
        }

        return 0;
    }
}
