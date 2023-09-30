package br.com.digitalhouse.games.app.api;

import br.com.digitalhouse.games.app.api.dto.request.CreateGameRequest;
import br.com.digitalhouse.games.app.api.dto.response.GameDetailedResponse;
import br.com.digitalhouse.games.app.api.dto.response.GameSumaryResponse;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RequestMapping("v1/games")
public interface GamesApi {

    @GetMapping
    ResponseEntity<Page<GameSumaryResponse>> buscarGames(@PageableDefault Pageable page);

    @PostMapping
    ResponseEntity<GameDetailedResponse> criarGame(@RequestBody @Valid CreateGameRequest request);

    @GetMapping("{id}")
    ResponseEntity<GameDetailedResponse> buscarGamePorId(@PathVariable UUID id);

    @PatchMapping("{id}")
    ResponseEntity<GameDetailedResponse> atualizarGamePorId(@PathVariable UUID id, Map<String, Object> campos);

    @DeleteMapping("{id}")
    ResponseEntity<Void> excluirGamePorId(@PathVariable UUID id);
}
