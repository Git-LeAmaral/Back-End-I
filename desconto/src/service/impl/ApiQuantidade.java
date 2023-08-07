package service.impl;

public class ApiQuantidade {
    //DESCONTO COM BASE NA API DE QUANTIDADE, SE MAIOR QUE 11 LOGO 15

    public int desconto(int quantidade) {

        if (quantidade >= 12) {
            System.out.println("Quantidade maior que 12, desconto de 15");
            return 15;
        }

        return 0;
    }
}
