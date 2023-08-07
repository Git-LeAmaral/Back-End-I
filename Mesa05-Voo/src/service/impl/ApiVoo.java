package service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
public class ApiVoo {
    public String buscarVoos() {
        List<String> linhaAereas = Arrays.asList("TAM", "Azul", "Gol");

        Random r = new Random();
        return linhaAereas.get(r.nextInt(linhaAereas.size()));
    }
}
