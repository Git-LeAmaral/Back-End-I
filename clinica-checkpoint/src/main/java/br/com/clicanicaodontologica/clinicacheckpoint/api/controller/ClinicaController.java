package br.com.clicanicaodontologica.clinicacheckpoint.api.controller;

import br.com.clicanicaodontologica.clinicacheckpoint.api.dto.request.ClinicaRequest;
import br.com.clicanicaodontologica.clinicacheckpoint.api.dto.response.*;
import br.com.clicanicaodontologica.clinicacheckpoint.domain.entity.Clinica;
import br.com.clicanicaodontologica.clinicacheckpoint.domain.entity.Contato;
import br.com.clicanicaodontologica.clinicacheckpoint.domain.entity.Endereco;
import br.com.clicanicaodontologica.clinicacheckpoint.domain.service.ClinicaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("clinicas")
public class ClinicaController {

    private final ClinicaService clinicaService;

    public ClinicaController(ClinicaService clinicaService) {
        this.clinicaService = clinicaService;
    }

    @GetMapping("{id}")
    ResponseEntity<ClinicaResponse> buscarPorId(@PathVariable UUID id) {
        Clinica clinica = clinicaService.buscarClinicaPorId(id);
        ClinicaResponse response = clinicaResponseByClinica(clinica);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    ResponseEntity<ClinicaWrapperResponse> buscarTodasClinicas() {
        List<Clinica> clinicas = clinicaService.buscarClinicas();

        ClinicaWrapperResponse clinicaWrapperResponse = new ClinicaWrapperResponse();
        clinicaWrapperResponse.setClinicas(clinicas.stream().map(clinica -> {
            ClinicaListResponse clinicaListResponse = new ClinicaListResponse();
            clinicaListResponse.setId(clinica.getId());
            clinicaListResponse.setNome(clinica.getNome());
            clinicaListResponse.setCnpj(clinica.getCnpj());
            return clinicaListResponse;
        }).toList());
        return ResponseEntity.ok(clinicaWrapperResponse);
    }

    @PostMapping
    ResponseEntity<?> criarClinica(@RequestBody ClinicaRequest request) {

        Clinica clinica = new Clinica();
        clinica.setCnpj(request.getCnpj());
        clinica.setNome(request.getNome());
        clinica.setRazaoSocial(request.getRazaoSocial());
        clinica.setDescricao(request.getDescricao());

        Contato contato = new Contato();
        contato.setEmail(request.getContato().getEmail());
        contato.setTelefone(request.getContato().getTelefone());

        Endereco endereco = new Endereco();
        endereco.setLogadouro(request.getEndereco().getLogadouro());
        endereco.setBairro(request.getEndereco().getBairro());
        endereco.setCidade(request.getEndereco().getCidade());
        endereco.setEstado(request.getEndereco().getEstado());
        endereco.setCep(request.getEndereco().getCep());

        clinica.setContato(contato);
        clinica.setEndereco(endereco);


        Clinica clinicaCriada = clinicaService.criar(clinica);
        return ResponseEntity.ok(clinicaCriada.getId());
    }


    private ClinicaResponse clinicaResponseByClinica(Clinica clinica) {

        ClinicaResponse clinicaResponse = new ClinicaResponse();
        clinicaResponse.setId(clinica.getId());
        clinicaResponse.setNome(clinica.getNome());
        clinicaResponse.setCnpj(clinica.getCnpj());
        clinicaResponse.setRazaoSocial(clinica.getRazaoSocial());
        clinicaResponse.setDescricao(clinica.getDescricao());

        ContatoResponse contato = new ContatoResponse();
        contato.setId(clinica.getContato().getId());
        contato.setEmail(clinica.getContato().getEmail());
        contato.setTelefone(clinica.getContato().getTelefone());

        EnderecoResponse endereco = new EnderecoResponse();
        endereco.setId(clinica.getEndereco().getId());
        endereco.setLogadouro(clinica.getEndereco().getLogadouro());
        endereco.setBairro(clinica.getEndereco().getBairro());
        endereco.setCidade(clinica.getEndereco().getCidade());
        endereco.setEstado(clinica.getEndereco().getEstado());
        endereco.setCep(clinica.getEndereco().getCep());

        clinicaResponse.setContato(contato);
        clinicaResponse.setEndereco(endereco);
        return clinicaResponse;
    }
}
