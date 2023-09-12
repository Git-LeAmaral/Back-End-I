package br.com.clicanicaodontologica.clinicacheckpoint.domain.service.impl;

import br.com.clicanicaodontologica.clinicacheckpoint.domain.entity.Paciente;
import br.com.clicanicaodontologica.clinicacheckpoint.domain.repository.PacienteRepository;
import br.com.clicanicaodontologica.clinicacheckpoint.domain.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public class PacienteServiceImpl implements PacienteService {

    private final PacienteRepository pacienteRepository;

    @Autowired
    public PacienteServiceImpl(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    public Paciente criarPaciente(Paciente paciente) {
        return null;
    }

    @Override
    public List<Paciente> buscarPacientes() {
        return null;
    }

    @Override
    public Paciente buscarPacientePorId(UUID id) {
        return null;
    }

    @Override
    public Paciente atualizarPaciente(UUID id) {
        return null;
    }

    @Override
    public void deletarPaciente(UUID id) {

    }
}
