package service.impl;

import model.Cartao;
import model.Produto;
import service.FacadeDesconto;

public class FacadeDescontoImpl implements FacadeDesconto {

    private ApiCartao apiCartao;
    private ApiProduto apiProduto;
    private ApiQuantidade apiQuantidade;

    public FacadeDescontoImpl() {
        this.apiCartao = new ApiCartao();
        this.apiProduto = new ApiProduto();
        this.apiQuantidade = new ApiQuantidade();
    }

    @Override
    public int desconto(Cartao cartao, Produto produto, int quantidade) {
        int descontoTotal = 0;

        descontoTotal += apiCartao.desconto(cartao);
        descontoTotal += apiProduto.desconto(produto);
        descontoTotal += apiQuantidade.desconto(quantidade);

        //descontoTotal = descontoTotal + apiCartao.desconto(cartao);
        //descontoTotal = descontoTotal + apiProduto.desconto(produto);
        //descontoTotal = descontoTotal + apiQuantidade.desconto(quantidade);

        return descontoTotal;
    }
}
