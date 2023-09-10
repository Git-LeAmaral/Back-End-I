package br.com.clicanicaodontologica.clinicacheckpoint.domain.service;

import br.com.clicanicaodontologica.clinicacheckpoint.domain.entity.Clinica;
import br.com.clicanicaodontologica.clinicacheckpoint.domain.repository.ClinicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClinicaServiceImpl implements ClinicaService {

    private final ClinicaRepository clinicaRepository;

    @Autowired
    public ClinicaServiceImpl(ClinicaRepository clinicaRepository) {
        this.clinicaRepository = clinicaRepository;
    }

    @Override
    public Clinica criar(Clinica clinica) {
        return this.clinicaRepository.save(clinica);
    }

    @Override
    public List<Clinica> buscarClinicas(String termo) {
        return this.clinicaRepository.findAll();
    }

    @Override
    public Clinica buscarClinicaPorId(UUID id) {
        return this.clinicaRepository.findById(id).orElseThrow();
    }
}
