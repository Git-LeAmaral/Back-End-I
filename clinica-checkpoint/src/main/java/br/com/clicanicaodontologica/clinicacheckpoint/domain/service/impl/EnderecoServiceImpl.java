package br.com.clicanicaodontologica.clinicacheckpoint.domain.service.impl;

import br.com.clicanicaodontologica.clinicacheckpoint.domain.entity.Endereco;
import br.com.clicanicaodontologica.clinicacheckpoint.domain.repository.EnderecoRepository;
import br.com.clicanicaodontologica.clinicacheckpoint.domain.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public class EnderecoServiceImpl implements EnderecoService {

    private final EnderecoRepository enderecoRepository;
    @Autowired
    public EnderecoServiceImpl(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    @Override
    public Endereco criarEndereco(Endereco endereco) {
        return null;
    }

    @Override
    public List<Endereco> buscarEnderecos() {
        return null;
    }

    @Override
    public Endereco buscarEnderecoPorId(UUID id) {
        return null;
    }

    @Override
    public Endereco atualizarEndereco(UUID id) {
        return null;
    }

    @Override
    public void deletarEndereco(UUID id) {

    }
}
