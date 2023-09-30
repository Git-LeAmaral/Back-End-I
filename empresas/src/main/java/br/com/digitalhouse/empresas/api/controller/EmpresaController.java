package br.com.digitalhouse.empresas.api.controller;

import br.com.digitalhouse.empresas.api.controller.api.dto.request.EmpresaRequest;
import br.com.digitalhouse.empresas.api.controller.api.dto.response.ContatoResponse;
import br.com.digitalhouse.empresas.api.controller.api.dto.response.EmpresaListResponse;
import br.com.digitalhouse.empresas.api.controller.api.dto.response.EmpresaResponse;
import br.com.digitalhouse.empresas.api.controller.api.dto.response.EmpresaWrapperResponse;
import br.com.digitalhouse.empresas.domain.entity.Contato;
import br.com.digitalhouse.empresas.domain.entity.Empresa;
import br.com.digitalhouse.empresas.domain.service.EmpresaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1/empresas")
public class EmpresaController {

    private final EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @GetMapping("{id}")
    ResponseEntity<EmpresaResponse> buscarPorId(@PathVariable UUID id) {
        Empresa empresa = empresaService.buscarEmpresaPorId(id);
        EmpresaResponse response = empresaResponseByEmpresa(empresa);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    ResponseEntity<EmpresaWrapperResponse> buscarTodosPorTermo(@RequestParam String termo) {
        List<Empresa> empresas = empresaService.buscarEmpresas(termo);
        EmpresaWrapperResponse empresaWrapperResponse = new EmpresaWrapperResponse();
        empresaWrapperResponse.setEmpresas(empresas.stream().map(empresa -> {
            EmpresaListResponse empresaListResponse = new EmpresaListResponse();
            empresaListResponse.setId(empresa.getId());
            empresaListResponse.setNome(empresa.getNome());
            empresaListResponse.setCnpj(empresa.getCnpj());
            return empresaListResponse;
        }).toList());
        return ResponseEntity.ok(empresaWrapperResponse);
    }

    @PostMapping
    ResponseEntity<?> criarEmpresa(@RequestBody @Valid EmpresaRequest request) {

        Empresa empresa = new Empresa();
        empresa.setCnpj(request.getCnpj());
        empresa.setNome(request.getNome());
        empresa.setNomeFantasia(request.getRazaoSocial());
        Contato contato = new Contato();
        contato.setEmail(request.getContato().getEmail());
        contato.setTelefone(request.getContato().getTelefone());

        empresa.setContato(contato);
        Empresa empresaCriada = empresaService.criar(empresa);
        return ResponseEntity.ok(empresaCriada.getId());
    }

    private EmpresaResponse empresaResponseByEmpresa(Empresa empresa) {
        EmpresaResponse empresaResponse = new EmpresaResponse();
        empresaResponse.setNome(empresa.getNome());
        empresaResponse.setCnpj(empresa.getCnpj());
        empresaResponse.setRazaoSocial(empresa.getNomeFantasia());
        empresaResponse.setId(empresa.getId());

        ContatoResponse contato = new ContatoResponse();
        contato.setEmail(empresa.getContato().getEmail());
        contato.setId(empresa.getContato().getId());
        contato.setTelefone(empresa.getContato().getTelefone());

        empresaResponse.setContato(contato);
        return empresaResponse;
    }
}
