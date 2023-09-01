package br.com.digitalhouse.clinica.domain.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class PacienteTest {

    @Test
    void dadoTodosOsParametrosNecessarios_quandoChamamosNovoPaciente_entaoRetornarPacientecomId() {
        String expectedNome = "Leandro";
        String expectedSobrenome = "Amaral";
        String expectedDocumento = "999.999.999.99";
        String expectedEmail = "leandro@gmail.com";
        String expectedTelefone = "(19) 9999-9999";
        Contato expectedContato = new Contato(expectedTelefone, expectedEmail);
        LocalDate expectedDataNascimento = LocalDate.of(1986, Month.NOVEMBER,11);
        GeneroEnum expectedGeneroEnum = GeneroEnum.M;

        Paciente pacienteCriado = Paciente.novoPaciente(
                expectedNome,
                expectedSobrenome,
                expectedDocumento,
                expectedDataNascimento,
                expectedContato,
                expectedGeneroEnum
        );

        Assertions.assertNotNull(pacienteCriado);
        Assertions.assertEquals(expectedNome, pacienteCriado.getNome());
        Assertions.assertEquals(expectedSobrenome, pacienteCriado.getSobrenome());
        Assertions.assertEquals(expectedDataNascimento, pacienteCriado.getDataNacimento());
        Assertions.assertEquals(expectedDocumento, pacienteCriado.getDocumento());
        Assertions.assertEquals(expectedEmail, pacienteCriado.getContato().getEmail());
        Assertions.assertEquals(expectedTelefone, pacienteCriado.getContato().getTelefone());
        Assertions.assertEquals(expectedGeneroEnum, pacienteCriado.getGenero());
    }

    @Test
    void omitidoNome_quandoChamamosNovoPaciente_entaoRetornarErroDeValidacao() {
        String expectedMensagemErro = "'nome' não informado!";
        String expectedSobrenome = "Amaral";
        String expectedDocumento = "999.999.999.99";
        String expectedEmail = "leandro@gmail.com";
        String expectedTelefone = "(19) 9999-9999";
        Contato expectedContato = new Contato(expectedTelefone, expectedEmail);
        LocalDate expectedDataNascimento = LocalDate.of(1986, Month.NOVEMBER,11);
        GeneroEnum expectedGeneroEnum = GeneroEnum.M;

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () ->
            Paciente.novoPaciente(
                    null,
                    expectedSobrenome,
                    expectedDocumento,
                    expectedDataNascimento,
                    expectedContato,
                    expectedGeneroEnum));
        Assertions.assertNotNull(exception);
        Assertions.assertEquals(expectedMensagemErro, exception.getMessage());
    }

}