package br.com.clicanicaodontologica.clinicacheckpoint.domain.service.impl;

import br.com.clicanicaodontologica.clinicacheckpoint.domain.entity.Clinica;
import br.com.clicanicaodontologica.clinicacheckpoint.domain.exception.BadRequestCnpjException;
import br.com.clicanicaodontologica.clinicacheckpoint.domain.exception.NotFoundException;
import br.com.clicanicaodontologica.clinicacheckpoint.domain.repository.ClinicaRepository;
import br.com.clicanicaodontologica.clinicacheckpoint.domain.service.ClinicaService;
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

        boolean cnpjExist = this.clinicaRepository.existsByCnpj(clinica.getCnpj());
        if (cnpjExist) {
            throw new BadRequestCnpjException(clinica.getCnpj());
        }
        return this.clinicaRepository.save(clinica);
    }

    @Override
    public List<Clinica> buscarClinicas() {

            return this.clinicaRepository.findAll();
    }

    @Override
    public Clinica buscarClinicaPorId(UUID id) {

        try {
            return this.clinicaRepository.findById(id).orElseThrow();

        } catch (Exception e) {
            throw new NotFoundException(id);
        }
    }

    @Override
    public Clinica atualizarClinica(UUID id, Clinica clinica) {
        try {
            clinicaRepository.findById(id).orElseThrow();
        } catch (Exception e) {
            throw new NotFoundException(id);
        }
        return clinicaRepository.save(clinica);
    }

    @Override
    public void deletarClinica(UUID id) {
        this.clinicaRepository.deleteById(id);
    }
}
