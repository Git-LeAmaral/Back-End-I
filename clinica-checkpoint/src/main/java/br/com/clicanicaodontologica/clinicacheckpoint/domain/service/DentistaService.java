package br.com.clicanicaodontologica.clinicacheckpoint.domain.service;

import br.com.clicanicaodontologica.clinicacheckpoint.domain.entity.Dentista;
import br.com.clicanicaodontologica.clinicacheckpoint.domain.entity.Paciente;

import java.util.List;
import java.util.UUID;

public interface DentistaService {

    Dentista criarDentista(Dentista dentista);
    List<Dentista> buscarDentistas();
    Dentista buscarDentistaPorId(UUID id);
    Dentista atualizarDentista(UUID id);
    void deletarDentista(UUID id);
}
