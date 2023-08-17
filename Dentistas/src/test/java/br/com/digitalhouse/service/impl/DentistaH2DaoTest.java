package br.com.digitalhouse.service.impl;

import br.com.digitalhouse.dao.IDao;
import br.com.digitalhouse.model.Dentista;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DentistaH2DaoTest {
    private final IDao<Dentista> dentistaH2Dao = new DentistaH2Dao();
    private final EasyRandom easyRandom = new EasyRandom();

    @Test
    void criar() {
        Dentista dentista = easyRandom.nextObject(Dentista.class);
        Dentista dentista1 = dentistaH2Dao.criar(dentista);
        Assertions.assertNotNull(dentista1.getId());
    }
}