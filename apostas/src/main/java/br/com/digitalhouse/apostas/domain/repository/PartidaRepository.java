package br.com.digitalhouse.apostas.domain.repository;

import br.com.digitalhouse.apostas.domain.entity.Partida;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartidaRepository extends MongoRepository<Partida, String> {
}
