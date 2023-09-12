package br.com.digitalhouse.apostas.domain.service.impl;

import br.com.digitalhouse.apostas.domain.entity.Partida;
import br.com.digitalhouse.apostas.domain.repository.PartidaRepository;
import br.com.digitalhouse.apostas.domain.service.PartidaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PartidaServiceImpl implements PartidaService {

    private final PartidaRepository repository;
    @Override
    public Partida criarPartida(Partida partida) {
        return repository.save(partida);
    }

    @Override
    public Partida buscarPartidaPorId(String id) {
        return repository.findById(id)
                .orElseThrow();
    }
}
