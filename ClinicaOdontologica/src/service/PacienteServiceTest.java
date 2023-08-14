package service;

import model.Paciente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class PacienteServiceTest {

    @Test
    void dadoNulo_quandoChamamosNomePaciente_entaoRetornarErro() {
        Paciente paciente = null;
        String nomePaciente = paciente.getNome();
        Assertions.assertNull(nomePaciente);
    }

    @Test
    void dadoOptional_quandoChamamosNomePaciente_entaoRetornarErro() {
        Optional<Paciente> optionalPaciente = Optional.empty();
        String cadastroNaoEncontrado = "Paciente não encontrado";
        String nomePaciente = optionalPaciente
                .map(paciente -> paciente.getNome())
                .orElse(cadastroNaoEncontrado);
        Assertions.assertEquals(cadastroNaoEncontrado, nomePaciente);
    }

}