package br.com.clicanicaodontologica.clinicacheckpoint.domain.service;

import br.com.clicanicaodontologica.clinicacheckpoint.domain.entity.Clinica;

import java.util.List;
import java.util.UUID;

public interface ClinicaService {

    Clinica criar(Clinica clinica);
    List<Clinica> buscarClinicas();
    Clinica buscarClinicaPorId(UUID id);
    Clinica atualizarClinica(UUID id);
    void deletarClinica(UUID id);
}
