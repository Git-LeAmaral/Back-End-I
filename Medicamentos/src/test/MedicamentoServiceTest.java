package test;

import dao.IDao;
import dao.impl.MedicamentoEmMemoriaDao;
import dao.impl.MedicamentoH2Dao;
import model.Medicamento;
import model.TipoLaboratorio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.MedicamentoService;

import java.util.List;

public class MedicamentoServiceTest {

    private MedicamentoService medicamentoService;

    @BeforeEach
    void setup() {
        IDao<Medicamento> medicamentoDao = new MedicamentoEmMemoriaDao();

        Medicamento medicamento = new Medicamento(1, "Dipirona", TipoLaboratorio.MEDLEY, 20, 20.9f);
        medicamentoDao.criar(medicamento);
        Medicamento medicamento1 = new Medicamento(2, "Cimegrip", TipoLaboratorio.EMS, 15, 26.9f);
        medicamentoDao.criar(medicamento1);
        Medicamento medicamento2 = new Medicamento(3, "Vick", TipoLaboratorio.INSTITUTO_BRASILEIRO, 31, 32.6f);
        medicamentoDao.criar(medicamento2);
        Medicamento medicamento3 = new Medicamento(4, "Torsilax", TipoLaboratorio.MEDLEY, 1, 50.8f);
        medicamentoDao.criar(medicamento3);

        medicamentoService  = new MedicamentoService(medicamentoDao);
    }
    @Test
    void dadoUmaConsultaEmMemoria_quandoChamamosBuscarTodos_entaoRetornarTodosOsMedicamentos(){
        List<Medicamento> medicamentosEncontrados = medicamentoService.buscarTodos();
        Assertions.assertEquals(4, medicamentosEncontrados.size());
    }

    @Test
    void dadoQuatroRegistrosEmMemoria_quandoChamamosAdicionamosUmRegistro_entaoRetornarCincoRegistros(){
        Medicamento medicamento = new Medicamento(5, "Semente dos Deuses",
                TipoLaboratorio.INSTITUTO_BRASILEIRO, 4, 250.5f);

        medicamentoService.criarMedicamento(medicamento);
        List<Medicamento> medicamentosEncontrados = medicamentoService.buscarTodos();
        Assertions.assertEquals(5, medicamentosEncontrados.size());
    }

    @Test
    void dadoBancoDeDadosH2_quandoChamamosAdicionamosUmRegistro_entaoRetornarCincoRegistros(){
        Medicamento medicamento = new Medicamento(5, "Semente dos Deuses",
                TipoLaboratorio.INSTITUTO_BRASILEIRO, 4, 250.5f);

        IDao<Medicamento> daoMedicamento = new MedicamentoH2Dao();
        MedicamentoService h2Service = new MedicamentoService(daoMedicamento);
        h2Service.criarMedicamento(medicamento);

        List<Medicamento> medicamentosEncontrados = medicamentoService.buscarTodos();
        Assertions.assertEquals(5, medicamentosEncontrados.size());
    }
}
