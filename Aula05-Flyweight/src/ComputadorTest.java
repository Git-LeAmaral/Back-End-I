import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComputadorTest {

    @Test
    void dadoAlgumasInstancias_quandoChamamosContador_entaoRetornarQuantasInstanciasForamCriadas() {
        Computador computador = new Computador(8, 500);
        Computador computador1 = new Computador(8, 500);
        Computador computador2 = new Computador(8, 500);
        Computador computador3 = new Computador(12, 1000);
        Computador computador4 = new Computador(12, 1000);
        Computador computador5 = new Computador(12, 1000);

        int valorEsperado = 6;
        Assertions.assertEquals(valorEsperado, Computador.contador );
    }

    @Test
    void dadoUmaFabricaComputador_quandoChamamosGetComputador_entaoValidaResultado() {
        FabricaComputador fabricaComputador = new FabricaComputador();

        fabricaComputador.getComputador(8, 500);

        int contadorEsperado = 1;
        Assertions.assertEquals(contadorEsperado, Computador.contador);
    }

    @Test
    void dadoUmaFabricaComputador_quandoChamamosGetComputador50_entaoValidaResultado() {
        FabricaComputador fabricaComputador = new FabricaComputador();
        Computador computador = null;
        fabricaComputador.getComputador(8, 500);

        for (int i = 0; i < 50; i++) {
            computador = fabricaComputador.getComputador(12, 1000);
            Computador computador2 = fabricaComputador.getComputador(10, 800);
        }

        int contadorEsperado = 1;
        Assertions.assertEquals(contadorEsperado, Computador.contador);
        Assertions.assertEquals(12, computador.getRam());
        Assertions.assertEquals(800, computador.getHd());
    }

}