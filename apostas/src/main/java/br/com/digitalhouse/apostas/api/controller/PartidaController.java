package br.com.digitalhouse.apostas.api.controller;

import br.com.digitalhouse.apostas.api.controller.dto.request.PartidaRequest;
import br.com.digitalhouse.apostas.api.controller.dto.response.PartidaResponse;
import br.com.digitalhouse.apostas.domain.entity.Partida;
import br.com.digitalhouse.apostas.domain.service.PartidaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("v1/partidas")
public class PartidaController {

    private final PartidaService partidaService;
    private final ObjectMapper mapper;
    @PostMapping
    public ResponseEntity<Void> criarPartida(@RequestBody PartidaRequest request) {
        Partida partida = mapper.convertValue(request, Partida.class);
        partidaService.criarPartida(partida);
        return ResponseEntity.ok().build();
    }
    @GetMapping("{id}")
    public ResponseEntity<PartidaResponse> buscarPartidaPorId(@PathVariable String id) {
        Partida partida = partidaService.buscarPartidaPorId(id);
        PartidaResponse partidaResponse = mapper.convertValue(partida, PartidaResponse.class);
        return ResponseEntity.ok(partidaResponse);
    }
}
