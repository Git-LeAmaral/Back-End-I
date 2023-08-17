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

import static org.junit.jupiter.api.Assertions.*;

class ServiceHotelTest {
    private ServiceHotel serviceHotel;

    @BeforeEach
    void setup() {
        IDao<Hotel> idaoHotel = new HotelH2Dao();
        Endereco endereco = new Endereco("Avenida bps", 51, "Itajuba", "MG");
        Hotel hotel = new Hotel("Teste01", endereco, Avaliacao.DUAS);
        idaoHotel.criar(hotel);
        serviceHotel = new ServiceHotel(idaoHotel);
    }

    @Test
    void dadoUmHotel_quandoChamamosCriar_entaoRetornarCriacao() {
        /*
        Paciente paciente = null;
        String nomePaciente = paciente.getNome();
        Assertions.assertNull(nomePaciente);

         */
    }

}