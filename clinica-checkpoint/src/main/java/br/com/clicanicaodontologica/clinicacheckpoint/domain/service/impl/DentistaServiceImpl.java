package br.com.clicanicaodontologica.clinicacheckpoint.domain.service.impl;

import br.com.clicanicaodontologica.clinicacheckpoint.domain.entity.Dentista;
import br.com.clicanicaodontologica.clinicacheckpoint.domain.repository.DentistaRepository;
import br.com.clicanicaodontologica.clinicacheckpoint.domain.service.DentistaService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public class DentistaServiceImpl implements DentistaService {

    private final DentistaRepository dentistaRepository;
    @Autowired
    public DentistaServiceImpl(DentistaRepository dentistaRepository) {
        this.dentistaRepository = dentistaRepository;
    }

    @Override
    public Dentista criarDentista(Dentista dentista) {
        return null;
    }

    @Override
    public List<Dentista> buscarDentistas() {
        return null;
    }

    @Override
    public Dentista buscarDentistaPorId(UUID id) {
        return null;
    }

    @Override
    public Dentista atualizarDentista(UUID id) {
        return null;
    }

    @Override
    public void deletarDentista(UUID id) {

    }
}
