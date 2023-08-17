package test;

import dao.IDao;
import dao.impl.HotelH2Dao;
import model.Avaliacao;
import model.Endereco;
import model.Hotel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.ServiceHotel;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ServiceHotelTest {
    private ServiceHotel serviceHotel;

    @BeforeEach
    void setup() {
        IDao<Hotel> idaoHotel = new HotelH2Dao();
        Hotel hotel = new Hotel("Prime Hotel",Avaliacao.CINCO, "Rua Janio Quadros", 455, "Campinas", "SP");
        idaoHotel.criar(hotel);
        Hotel hotel02 = new Hotel("Cassino Tower Hotel Campinas",Avaliacao.CINCO, "Av das Amoreiras", 56, "Campinas", "SP");
        idaoHotel.criar(hotel02);
        Hotel hotel03 = new Hotel("I Am Design Hotel + Residence",Avaliacao.TRES, "Rod. Anhanguera", 89, "Campinas", "SP");
        idaoHotel.criar(hotel03);
        Hotel hotel04 = new Hotel("Meliá Campinas",Avaliacao.QUATRO, "Dr. Manoel Affonso", 667, "Campinas", "SP");
        idaoHotel.criar(hotel04);
        Hotel hotel05 = new Hotel("Vitória Hotel Express Dom Pedro",Avaliacao.DUAS, "Antonio Volpe", 335, "Campinas", "SP");
        idaoHotel.criar(hotel05);
        serviceHotel = new ServiceHotel(idaoHotel);

    }

    @Test
    void dadoUmaConsultaDeHotel_quandoChamamosBuscarTodos_entaoRetornarTodosHoteis() {

        List<Hotel> hoteisEncontrados = serviceHotel.buscarTodos();

        Assertions.assertEquals(5, hoteisEncontrados.size());
    }

    @Test
    void dadoUmHotel_quandoChamamosCriar_entaoRetornarCriacao() {

        Hotel hotel = new Hotel("Prime Hotel",Avaliacao.CINCO, "Rua Janio Quadros", 455, "Campinas", "SP");
        serviceHotel.criarHotel(hotel);
        serviceHotel.buscarId(hotel.getId());

    }

    @Test
    void dadoUmHotel_quandoChamamosExcluir_entaoRetornamosHoteisMenosUm() {

        Hotel hotel = new Hotel("Hotel Bela vista",Avaliacao.CINCO, "Rua Janio Quadros", 455, "Campinas", "SP");
        serviceHotel.criarHotel(hotel);
        serviceHotel.excluirHotel(hotel.getId());
    }

}