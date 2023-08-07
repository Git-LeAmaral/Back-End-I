package service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ApiHotel {
    public String buscarHoteis() {
        List<String> hoteis = Arrays.asList("Thee Royal Palace", "Gold of Eishwage", "L'hôtel fantastique");

        Random r = new Random();
        int tamanhoTotal = hoteis.size();
        int hotelEncontrado = r.nextInt(tamanhoTotal);
        String nomeHotel = hoteis.get(hotelEncontrado);
        return nomeHotel;
    }
}