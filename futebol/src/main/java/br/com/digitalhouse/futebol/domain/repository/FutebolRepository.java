package br.com.digitalhouse.futebol.domain.repository;

import br.com.digitalhouse.futebol.domain.entity.Futebol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface FutebolRepository extends JpaRepository<Futebol, UUID> {

    List<Futebol> findByDataEventoIs(LocalDate date);

    List<Futebol> findByNomeStartingWith(String prefixo);
}
