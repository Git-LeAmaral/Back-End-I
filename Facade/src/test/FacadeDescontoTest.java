package test;

import model.BancoEnum;
import model.Cartao;
import model.Produto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.FacadeDesconto;
import service.impl.FacadeDescontoImpl;

import static org.junit.jupiter.api.Assertions.*;

class FacadeDescontoTest {

    private Produto produto;
    private Cartao cartao;

    @BeforeEach
    void setup() {
        produto = new Produto("Guaraná Jesus", "Guaraná");
        cartao = new Cartao("9999", BancoEnum.STAR_BANK);
        System.out.println("Executando antes do teste");
    }

    @Test
    void dadoUmCartaoComDesconto_quandoChamamosDescontoFacade_entaoRetornar20DeDesconto() {
        FacadeDesconto facadeDesconto = new FacadeDescontoImpl();
        int resultadoEsperado = 20;

        int resultado = facadeDesconto.desconto(cartao, produto, 10);
        System.out.println("---------------------------------------------------------");

        Assertions.assertEquals(resultadoEsperado, resultado);
    }

    @Test
    void dadoUmaQuantidadeDe15_quandoChamamosDescontoFacade_entaoRetornar15DeDesconto() {
        FacadeDesconto facadeDesconto = new FacadeDescontoImpl();
        int resultadoEsperado  = 15;

        Cartao cartaoSantander = new Cartao("9999", BancoEnum.SANTANDER);
        int resultado = facadeDesconto.desconto(cartaoSantander, produto, 15);
        System.out.println("-------------------------------------------------------------");

        Assertions.assertEquals(resultadoEsperado, resultado);
    }

    @Test
    void dadoUmProdutoEnlatado_quandoChamamosDescontoFacade_entaoRetornar10DeDesconto() {
        FacadeDesconto facadeDesconto = new FacadeDescontoImpl();
        int resultadoEsperado = 10;

        produto.setTipo("Lata");
        cartao.setBanco(BancoEnum.BRADESCO);
        int resultado = facadeDesconto.desconto(cartao, produto, 1);
        System.out.println("---------------------------------------------------------");

        Assertions.assertEquals(resultadoEsperado, resultado);
    }

    @Test
    void dadoTudoComDesconto_quandoChamamosDescontoFacade_entaoRetornar45DeDesconto() {
        FacadeDesconto facadeDesconto = new FacadeDescontoImpl();
        int resultadoEsperado = 45;

        produto.setTipo("Lata");
        int resultado = facadeDesconto.desconto(cartao, produto, 18);
        System.out.println("---------------------------------------------------------");
        Assertions.assertEquals(resultadoEsperado, resultado);
    }

}