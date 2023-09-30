package br.com.clicanicaodontologica.clinicacheckpoint.api.controller;

import br.com.clicanicaodontologica.clinicacheckpoint.api.dto.request.DentistaRequest;
import br.com.clicanicaodontologica.clinicacheckpoint.api.dto.response.ContatoResponse;
import br.com.clicanicaodontologica.clinicacheckpoint.api.dto.response.DentistaResponse;
import br.com.clicanicaodontologica.clinicacheckpoint.api.dto.response.list.DentistaListResponse;
import br.com.clicanicaodontologica.clinicacheckpoint.api.dto.response.wrapper.DentistaWrapperResponse;
import br.com.clicanicaodontologica.clinicacheckpoint.domain.entity.Contato;
import br.com.clicanicaodontologica.clinicacheckpoint.domain.entity.Dentista;
import br.com.clicanicaodontologica.clinicacheckpoint.domain.service.DentistaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1/dentistas")
@Tag(name = "Dentistas")
public class DentistaController {

    private final DentistaService dentistaService;

    @Autowired
    public DentistaController(DentistaService dentistaService) {
        this.dentistaService = dentistaService;
    }

    @GetMapping
    ResponseEntity<DentistaWrapperResponse> buscarDentistas(@RequestParam(required = false) String termo) {
        List<Dentista> dentistas = dentistaService.buscarDentistas(termo);
        DentistaWrapperResponse dentistaWrapperResponse = new DentistaWrapperResponse();

        dentistaWrapperResponse.setDentistas(dentistas.stream().map(dentista -> {
            DentistaListResponse dentistaListResponse = new DentistaListResponse();
            dentistaListResponse.setId(dentista.getId());
            dentistaListResponse.setNome(dentista.getNome());
            dentistaListResponse.setCro(dentista.getCro());
            return dentistaListResponse;
        }).toList());

        return ResponseEntity.ok(dentistaWrapperResponse);
    }

    @GetMapping("{id}")
    ResponseEntity<DentistaResponse> buscarDentistaPorId(@PathVariable UUID id) {
        Dentista dentista = dentistaService.buscarDentistaPorId(id);
        DentistaResponse response = dentistaResponseByDentista(dentista);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    ResponseEntity<DentistaResponse> criarDentista(@RequestBody @Valid DentistaRequest request) {

        Dentista dentista = new Dentista();
        dentista.setNome(request.getNome());
        dentista.setCro(request.getCro());
        dentista.setDataNascimento(request.getDataNascimento());
        dentista.setEspecialidadeEnum(request.getEspecialidadeEnum());
        dentista.setGeneroEnum(request.getGeneroEnum());

        Contato contato = new Contato();
        contato.setEmail(request.getContato().getEmail());
        contato.setTelefone(request.getContato().getTelefone());
        dentista.setContato(contato);

        dentista.setClinicasDentistas(request.getClinicasDentistas());

        Dentista dentistaCriado = dentistaService.criarDentista(dentista);
        DentistaResponse response = dentistaResponseByDentista(dentistaCriado);

        return ResponseEntity.ok(response);
    }

    @PutMapping("{id}")
    ResponseEntity<DentistaResponse> atualizarDentista(@PathVariable UUID id, @RequestBody @Valid DentistaRequest request) {

        Dentista dentista = dentistaService.buscarDentistaPorId(id);

        dentista.setNome(request.getNome());
        dentista.setCro(request.getCro());
        dentista.setDataNascimento(request.getDataNascimento());
        dentista.setEspecialidadeEnum(request.getEspecialidadeEnum());
        dentista.setGeneroEnum(request.getGeneroEnum());

        Contato contato = new Contato();
        contato.setEmail(request.getContato().getEmail());
        contato.setTelefone(request.getContato().getTelefone());
        dentista.setContato(contato);

        dentista.setClinicasDentistas(request.getClinicasDentistas());

        Dentista dentistaAtualizado = dentistaService.criarDentista(dentista);
        DentistaResponse response = dentistaResponseByDentista(dentistaAtualizado);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("{id}")
    ResponseEntity<Void> deletarDentista(@PathVariable UUID id) {
        dentistaService.deletarDentista(id);
        return ResponseEntity.ok().build();
    }

    private DentistaResponse dentistaResponseByDentista(Dentista dentista) {

        DentistaResponse dentistaResponse = new DentistaResponse();
        dentistaResponse.setId(dentista.getId());
        dentistaResponse.setNome(dentista.getNome());
        dentistaResponse.setCro(dentista.getCro());
        dentistaResponse.setDataNascimento(dentista.getDataNascimento());
        dentistaResponse.setEspecialidadeEnum(dentista.getEspecialidadeEnum());
        dentistaResponse.setGeneroEnum(dentista.getGeneroEnum());
        dentistaResponse.setCreatedAt(dentista.getCreatedAt());
        dentistaResponse.setUpdatedAt(dentista.getUpdatedAt());

        ContatoResponse contato = new ContatoResponse();
        contato.setId(dentista.getContato().getId());
        contato.setEmail(dentista.getContato().getEmail());
        contato.setTelefone(dentista.getContato().getTelefone());
        contato.setCreatedAt(dentista.getContato().getCreatedAt());
        contato.setUpdatedAt(dentista.getContato().getUpdatedAt());

        dentistaResponse.setContato(contato);
        dentistaResponse.setClinicasDentistas(dentista.getClinicasDentistas());

        return dentistaResponse;
    }
}
