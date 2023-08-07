package service.impl;

import model.Hotel;
import model.Voo;
import service.FacadeBusca;

public class FacadeBuscaImpl implements FacadeBusca {

    private ApiHotel apiHotel;
    private ApiVoo apiVoo;

    public FacadeBuscaImpl() {
        System.out.println("Construindo facade busca impl");
        this.apiHotel = new ApiHotel();
        this.apiVoo = new ApiVoo();
    }


    @Override
    public String buscarHotelVoo(Hotel hotel, Voo voo) {
        boolean verificaCidade = hotel.getCidade().equals(voo.getDestino());
        if (verificaCidade) {
            String retorno = "Hotel Disponivel: " + apiHotel.buscarHoteis() + "\nVoo disponível: " + apiVoo.buscarVoos();
            return retorno;
        }
        return null;
    }
}
