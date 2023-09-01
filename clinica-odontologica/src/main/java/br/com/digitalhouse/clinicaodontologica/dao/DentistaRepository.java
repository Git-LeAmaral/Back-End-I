package br.com.digitalhouse.clinicaodontologica.dao;

import br.com.digitalhouse.clinicaodontologica.domain.entity.Dentista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DentistaRepository extends JpaRepository<Dentista, Integer> {
}
