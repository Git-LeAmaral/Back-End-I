package mesa01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CartaoTest {
    @Test
    @DisplayName("DADO CARTAO COM 20 CARACTERES RETORNA TRUE")
    public void dadoCartao20Caracteres_quandoValidamosQuantidade_entaoRetornaTrue() {
        //dado
        String nome = "Leandro";
        CartaoCredito cartao01 = new CartaoCredito("Leandro", "4652 3146 4695 4569 ");
        //quando
        boolean tem20Caracteres = cartao01.tem20Caracteres();
        //então
        Assertions.assertTrue(tem20Caracteres);
        Assertions.assertEquals(nome, cartao01.getNome());
    }
}
