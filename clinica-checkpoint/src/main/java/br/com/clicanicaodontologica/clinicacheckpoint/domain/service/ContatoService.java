package br.com.clicanicaodontologica.clinicacheckpoint.domain.service;

import br.com.clicanicaodontologica.clinicacheckpoint.domain.entity.Contato;
import br.com.clicanicaodontologica.clinicacheckpoint.domain.entity.Dentista;

import java.util.List;
import java.util.UUID;

public interface ContatoService {

    Contato criarContato(Contato contato);
    List<Contato> buscarContatos();
    Contato buscarContatoPorId(UUID id);
    Contato atualizarContato(UUID id);
    void deletarContato(UUID id);
}
