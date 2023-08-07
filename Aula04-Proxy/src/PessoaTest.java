import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class PessoaTest {

    @Test
    @DisplayName("DADO SERVICO ")
    void dadoServicoVacinar_quandoChamamosVacinar_entaoRetornarMensagemDeSucesso() {
        Pessoa Leandro = new Pessoa("Leandro", "Amaral", "7847399834", "Lion", LocalDate.now());

        Vacinar servico = new ServicoVacinar();
        servico.vacinar(Leandro.getRg(), Leandro.getDataVacina(), Leandro.getNomeVacina());
    }

    @Test
    void dadoServicoVacinarProxy_quandoChamamosVacinar_entaoValidarSePodeSerVAcinadoAntes() {
        String nome = "Michelle";
        String sobrenome = "Amaral";
        String rg = "111222133";
        String vacina = "Vacina da dengue";
        LocalDate dataVacina = LocalDate.of(2023, Month.APRIL, 12);

        Pessoa Michelle = new Pessoa(nome, sobrenome, rg, vacina,dataVacina);

        Vacinar vacinaService = new ServicoProxyVacinar();

        String resultado = vacinaService.vacinar(Michelle.getRg(), Michelle.getDataVacina(), Michelle.getNomeVacina());

        Assertions.assertNotNull(resultado);
        Assertions.assertEquals("cidadão vacinado com proxy", resultado);
    }
}