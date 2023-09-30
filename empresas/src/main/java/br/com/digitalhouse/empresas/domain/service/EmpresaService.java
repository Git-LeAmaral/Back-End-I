package br.com.digitalhouse.empresas.domain.service;

import br.com.digitalhouse.empresas.domain.entity.Empresa;

import java.util.List;
import java.util.UUID;

public interface EmpresaService {

    Empresa criar(Empresa empresa);

    List<Empresa> buscarEmpresas(String termo);
    Empresa buscarEmpresaPorId(UUID id);
}
