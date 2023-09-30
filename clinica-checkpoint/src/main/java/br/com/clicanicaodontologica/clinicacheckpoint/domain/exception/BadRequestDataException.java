package br.com.clicanicaodontologica.clinicacheckpoint.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.Instant;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequestDataException extends RuntimeException {
    public BadRequestDataException(Instant data) {
        super("Esta data: " + data + " é antes da data atual");
    }
}
