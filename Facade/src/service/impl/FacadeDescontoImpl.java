package service.impl;

import model.Cartao;
import model.Produto;
import org.apache.log4j.Logger;
import service.FacadeDesconto;

public class FacadeDescontoImpl implements FacadeDesconto {

    private static final Logger logger = Logger.getLogger(FacadeDescontoImpl.class);
    private ApiCartao apiCartao;
    private ApiProduto apiProduto;
    private ApiQuantidade apiQuantidade;

    public FacadeDescontoImpl() {
        logger.info("Construindo facade desconto impl");
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
        return descontoTotal;
    }
}
