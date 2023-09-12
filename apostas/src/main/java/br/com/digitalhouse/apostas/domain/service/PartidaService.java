package br.com.digitalhouse.apostas.domain.service;

import br.com.digitalhouse.apostas.domain.entity.Partida;

public interface PartidaService {
    Partida criarPartida(Partida partida);

    Partida buscarPartidaPorId(String id);
}
