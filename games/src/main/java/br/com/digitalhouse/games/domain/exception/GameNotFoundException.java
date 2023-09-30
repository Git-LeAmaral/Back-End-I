package br.com.digitalhouse.games.domain.exception;

import java.util.UUID;

public class GameNotFoundException extends RuntimeException {

    public GameNotFoundException(UUID gameId) {
        super("Game com id: 5s não encontrado! Reveja o que foi solicitado.".formatted(gameId));
    }
}
