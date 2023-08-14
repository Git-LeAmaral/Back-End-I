package service;

import dao.IDao;
import model.Paciente;

import java.util.Optional;

public class PacienteService {
    private IDao<Paciente, Integer> daoPaciente;


    public Paciente buscarPacientePorId(Integer id) {
        return daoPaciente
                .buscarPorId(id)
                .orElseThrow();
    }

    public Paciente criarPaciente(Paciente paciente) {
        return daoPaciente.criar(paciente);
    }

    public Paciente atualizarPaciente(Integer id, Paciente paciente) {
        return daoPaciente.atualizar(id, paciente);
    }

    public void excluirPaciente(Integer id) {
        daoPaciente.excluir(id);
    }
}
