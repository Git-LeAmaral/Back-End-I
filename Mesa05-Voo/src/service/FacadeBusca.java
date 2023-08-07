package service;

import model.Hotel;
import model.Voo;

import java.time.LocalDate;

public interface FacadeBusca {
    public String buscarHotelVoo(Hotel hotel, Voo voo);
}
