package br.com.clicanicaodontologica.clinicacheckpoint.api.controller;

import br.com.clicanicaodontologica.clinicacheckpoint.api.dto.request.PacienteRequest;
import br.com.clicanicaodontologica.clinicacheckpoint.api.dto.response.ContatoResponse;
import br.com.clicanicaodontologica.clinicacheckpoint.api.dto.response.EnderecoResponse;
import br.com.clicanicaodontologica.clinicacheckpoint.api.dto.response.PacienteResponse;
import br.com.clicanicaodontologica.clinicacheckpoint.api.dto.response.list.PacienteListResponse;
import br.com.clicanicaodontologica.clinicacheckpoint.api.dto.response.wrapper.PacienteWrapperResponse;
import br.com.clicanicaodontologica.clinicacheckpoint.domain.entity.Contato;
import br.com.clicanicaodontologica.clinicacheckpoint.domain.entity.Endereco;
import br.com.clicanicaodontologica.clinicacheckpoint.domain.entity.Paciente;
import br.com.clicanicaodontologica.clinicacheckpoint.domain.service.PacienteService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1/pacientes")
@Tag(name = "Pacientes")
public class PacienteController {

    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping
    ResponseEntity<PacienteWrapperResponse> buscarPacientes(@RequestParam(required = false) String termo) {

        List<Paciente> pacientes = pacienteService.buscarPacientes(termo);
        PacienteWrapperResponse pacienteWrapperResponse = new PacienteWrapperResponse();

        pacienteWrapperResponse.setPacientes(pacientes.stream().map(paciente -> {
            PacienteListResponse pacienteListResponse = new PacienteListResponse();
            pacienteListResponse.setId(paciente.getId());
            pacienteListResponse.setNome(paciente.getNome());

            return pacienteListResponse;
        }).toList());

        return ResponseEntity.ok(pacienteWrapperResponse);
    }

    @GetMapping("{id}")
    ResponseEntity<PacienteResponse> buscarPacientePorId(@PathVariable UUID id) {

        Paciente paciente = pacienteService.buscarPacientePorId(id);
        PacienteResponse response = pacienteResponseByPaciente(paciente);

        return ResponseEntity.ok(response);
    }

    @PostMapping
    ResponseEntity<PacienteResponse> criarPaciente(@RequestBody @Valid PacienteRequest request) {

        Paciente paciente = new Paciente();
        paciente.setNome(request.getNome());
        paciente.setDataNascimento(request.getDataNascimento());
        paciente.setGeneroEnum(request.getGenero());

        Contato contato = new Contato();
        contato.setEmail(request.getContato().getEmail());
        contato.setTelefone(request.getContato().getTelefone());
        paciente.setContato(contato);

        Endereco endereco = new Endereco();
        endereco.setLogadouro(request.getEndereco().getLogadouro());
        endereco.setBairro(request.getEndereco().getBairro());
        endereco.setCidade(request.getEndereco().getCidade());
        endereco.setEstado(request.getEndereco().getEstado());
        endereco.setCep(request.getEndereco().getCep());
        paciente.setEndereco(endereco);

        Paciente pacienteCriado = pacienteService.criarPaciente(paciente);
        PacienteResponse response = pacienteResponseByPaciente(pacienteCriado);

        return ResponseEntity.ok(response);
    }

    @PutMapping("{id}")
    ResponseEntity<PacienteResponse> atualizarPaciente(@PathVariable UUID id, @RequestBody @Valid PacienteRequest request) {
        Paciente paciente = pacienteService.buscarPacientePorId(id);

        paciente.setNome(request.getNome());
        paciente.setDataNascimento(request.getDataNascimento());
        paciente.setGeneroEnum(request.getGenero());

        Contato contato = new Contato();
        contato.setEmail(request.getContato().getEmail());
        contato.setTelefone(request.getContato().getTelefone());
        paciente.setContato(contato);

        Endereco endereco = new Endereco();
        endereco.setLogadouro(request.getEndereco().getLogadouro());
        endereco.setBairro(request.getEndereco().getBairro());
        endereco.setCidade(request.getEndereco().getCidade());
        endereco.setEstado(request.getEndereco().getEstado());
        endereco.setCep(request.getEndereco().getCep());
        paciente.setEndereco(endereco);

        Paciente pacienteAtualizado = pacienteService.atualizarPaciente(id, paciente);
        PacienteResponse response = pacienteResponseByPaciente(pacienteAtualizado);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("{id}")
    ResponseEntity<Void> deletarPaciente(@PathVariable UUID id) {

        pacienteService.deletarPaciente(id);

        return ResponseEntity.ok().build();
    }

    private PacienteResponse pacienteResponseByPaciente(Paciente paciente) {

        PacienteResponse pacienteResponse = new PacienteResponse();
        pacienteResponse.setId(paciente.getId());
        pacienteResponse.setNome(paciente.getNome());
        pacienteResponse.setDataNascimento(paciente.getDataNascimento());
        pacienteResponse.setGenero(paciente.getGeneroEnum());
        pacienteResponse.setCreatedAt(paciente.getCreatedAt());
        pacienteResponse.setUpdatedAt(paciente.getUpdatedAt());

        ContatoResponse contato = new ContatoResponse();
        contato.setId(paciente.getContato().getId());
        contato.setEmail(paciente.getContato().getEmail());
        contato.setTelefone(paciente.getContato().getTelefone());
        contato.setCreatedAt(paciente.getContato().getCreatedAt());
        contato.setUpdatedAt(paciente.getContato().getUpdatedAt());

        EnderecoResponse endereco = new EnderecoResponse();
        endereco.setId(paciente.getEndereco().getId());
        endereco.setLogadouro(paciente.getEndereco().getLogadouro());
        endereco.setBairro(paciente.getEndereco().getBairro());
        endereco.setCidade(paciente.getEndereco().getCidade());
        endereco.setEstado(paciente.getEndereco().getEstado());
        endereco.setCep(paciente.getEndereco().getCep());

        pacienteResponse.setContato(contato);
        pacienteResponse.setEndereco(endereco);

        return pacienteResponse;
    }
}
