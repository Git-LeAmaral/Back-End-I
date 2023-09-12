package br.com.clicanicaodontologica.clinicacheckpoint.domain.service.impl;

import br.com.clicanicaodontologica.clinicacheckpoint.domain.entity.Contato;
import br.com.clicanicaodontologica.clinicacheckpoint.domain.repository.ContatoRepository;
import br.com.clicanicaodontologica.clinicacheckpoint.domain.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public class ContatoServiceImpl implements ContatoService {

    private final ContatoRepository contatoRepository;
    @Autowired
    public ContatoServiceImpl(ContatoRepository contatoRepository) {
        this.contatoRepository = contatoRepository;
    }

    @Override
    public Contato criarContato(Contato contato) {
        return null;
    }

    @Override
    public List<Contato> buscarContatos() {
        return null;
    }

    @Override
    public Contato buscarContatoPorId(UUID id) {
        return null;
    }

    @Override
    public Contato atualizarContato(UUID id) {
        return null;
    }

    @Override
    public void deletarContato(UUID id) {

    }
}
