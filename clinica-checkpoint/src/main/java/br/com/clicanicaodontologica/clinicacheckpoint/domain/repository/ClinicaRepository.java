package br.com.clicanicaodontologica.clinicacheckpoint.domain.repository;

import br.com.clicanicaodontologica.clinicacheckpoint.domain.entity.Clinica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClinicaRepository extends JpaRepository<Clinica, UUID> {
    boolean existsByCnpj(String cnpj);
}
