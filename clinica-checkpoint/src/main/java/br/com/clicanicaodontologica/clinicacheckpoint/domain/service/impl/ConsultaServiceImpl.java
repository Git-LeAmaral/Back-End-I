package br.com.clicanicaodontologica.clinicacheckpoint.domain.service.impl;

import br.com.clicanicaodontologica.clinicacheckpoint.domain.entity.Consulta;
import br.com.clicanicaodontologica.clinicacheckpoint.domain.repository.ConsultaRepository;
import br.com.clicanicaodontologica.clinicacheckpoint.domain.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public class ConsultaServiceImpl implements ConsultaService {

    private final ConsultaRepository consultaRepository;
    @Autowired
    public ConsultaServiceImpl(ConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }

    @Override
    public Consulta criarConsulta(Consulta consulta) {
        return null;
    }

    @Override
    public List<Consulta> buscarConsultas() {
        return null;
    }

    @Override
    public Consulta buscarConsultaPorId(UUID id) {
        return null;
    }

    @Override
    public Consulta atualizarConsulta(UUID id) {
        return null;
    }

    @Override
    public void deletarConsulta(UUID id) {

    }
}
