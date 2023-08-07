package test;

import model.Hotel;
import model.Voo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import service.impl.FacadeBuscaImpl;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;


class FacadeBuscaTest {
    @Test
    void dadoUmaCidadeDestino_quandoForemIguais_entaoRetornarHoteisEVoos() {
        FacadeBuscaImpl facadeBusca = new FacadeBuscaImpl();


        Voo voo = new Voo(LocalDate.of(2000, Month.APRIL, 10), LocalDate.of(2000, Month.APRIL, 14), "Itajuba", "SP");
        Hotel hotel = new Hotel(LocalDate.of(2000, Month.APRIL, 10), LocalDate.of(2000, Month.APRIL, 14),"SP");

        String resultado = facadeBusca.buscarHotelVoo(hotel, voo);
        System.out.println(resultado);

        //Assertions.assertEquals();
    }

}