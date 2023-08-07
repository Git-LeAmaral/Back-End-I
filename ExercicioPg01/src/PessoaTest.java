import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PessoaTest {

    @Test
    public void seEMaiorDe18() {
        Pessoa pessoa01 = new Pessoa("Leandro", 36);
        Pessoa pessoa02 = new Pessoa("Michelle", 34);
        Pessoa pessoa03 = new Pessoa("Mariane", 20);

        boolean isMaior18 = pessoa01.isMaior18();

        Assertions.assertTrue(isMaior18);
    }

    @Test
    public void temMaisDe5Letras() {
        Pessoa pessoa01 = new Pessoa("Leandro", 36);
        Pessoa pessoa02 = new Pessoa("Michelle", 34);
        Pessoa pessoa03 = new Pessoa("Mari", 20);

        boolean temMaisDe5Letras = pessoa02.temMaisDe5Letras();

        Assertions.assertTrue(temMaisDe5Letras);
    }

}