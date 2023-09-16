package br.com.clicanicaodontologica.clinicacheckpoint.api.handler;

import br.com.clicanicaodontologica.clinicacheckpoint.domain.exception.BadRequestException;
import br.com.clicanicaodontologica.clinicacheckpoint.domain.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class ExceptionApiHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Problema> notFoundExceptionHandler(NotFoundException e) {
        String message = "Id não encontrado no Sistema!";
        Problema problem = new Problema(HttpStatus.NOT_FOUND.value(), message, e.getMessage());
        return ResponseEntity.ok().body(problem);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Problema> badRequestExceptionHandler(BadRequestException e) {
        String message = "Clínica com CNPJ ou nome já cadastrados!";
        Problema problem = new Problema(HttpStatus.BAD_REQUEST.value(), message, e.getMessage());
        return ResponseEntity.ok().body(problem);
    }
}