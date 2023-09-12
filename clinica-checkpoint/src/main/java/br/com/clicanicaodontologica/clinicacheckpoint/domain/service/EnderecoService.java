package br.com.clicanicaodontologica.clinicacheckpoint.domain.service;

import br.com.clicanicaodontologica.clinicacheckpoint.domain.entity.Endereco;
import br.com.clicanicaodontologica.clinicacheckpoint.domain.entity.Paciente;

import java.util.List;
import java.util.UUID;

public interface EnderecoService {

    Endereco criarEndereco(Endereco endereco);
    List<Endereco> buscarEnderecos();
    Endereco buscarEnderecoPorId(UUID id);
    Endereco atualizarEndereco(UUID id);
    void deletarEndereco(UUID id);
}
