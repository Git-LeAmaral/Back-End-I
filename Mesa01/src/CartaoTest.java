import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CartaoTest {

    @Test
    @DisplayName("DADO CARTAO COM 20 CARACTERES RETORNA TRUE")
    public void dadoCartaocom20Caracteres_quandoValidamosQuantidade_entaoRetornaTrue() {
        //dado
        String nome = "Andrea";
        CartaoCredito cartao01 = new CartaoCredito(nome, "4956 3213 9090 4455 ");
        //quando
        boolean tem20Caracteres = cartao01.tem20Caracteres();
        //então
        Assertions.assertTrue(tem20Caracteres);
        Assertions.assertEquals(nome, cartao01.getNome());
    }



}
