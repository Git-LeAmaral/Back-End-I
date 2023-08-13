package service;

import dao.IDao;
import model.Medicamento;

import java.util.List;

public class MedicamentoService {

    private final IDao<Medicamento> daoMEdicamento;

    public MedicamentoService(IDao<Medicamento> daoMEdicamento) {
        this.daoMEdicamento = daoMEdicamento;
    }

    public Medicamento criarMedicamento(Medicamento medicamento) {
        return null;
    }

    public void excluirMedicamento(Integer id) {

    }

    public List<Medicamento> buscarTodos() {
        return null;
    }

    public Medicamento buscaPorId(Integer id) {
        return null;
    }
}
