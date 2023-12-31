package br.com.clicanicaodontologica.clinicacheckpoint.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

    public NotFoundException(UUID id) {
        super("Entidade de id: %s não encontrada!".formatted(id));
    }
}
