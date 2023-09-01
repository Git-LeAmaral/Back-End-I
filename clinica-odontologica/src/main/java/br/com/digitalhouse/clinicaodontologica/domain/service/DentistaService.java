package br.com.digitalhouse.clinicaodontologica.domain.service;

import br.com.digitalhouse.clinicaodontologica.domain.entity.Dentista;

import java.util.Optional;

public interface DentistaService {

    Optional<Dentista> buscarPorId(Integer id);
    Dentista criarDentista(Dentista dentista);

    Dentista atualizarDentista(Dentista dentista);
}
