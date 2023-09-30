package br.com.digitalhouse.games.domain.repository;

import br.com.digitalhouse.games.domain.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GameRepository extends JpaRepository<Game, UUID> {
}
