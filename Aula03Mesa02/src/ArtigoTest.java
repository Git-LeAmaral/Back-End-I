import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArtigoTest {

    @Test
    public void dadoProduto_quandoPossuiLotePesoEmbalagemCorreto_entaoAprovarProduto() {
        //dado
        Artigo artigo = new Artigo("Chuteira", 1500, 1250, "Saudavel");
        //quando
        CheckQuality processador = new CheckQuality();
        //entao
        processador.verificar(artigo);
    }


}