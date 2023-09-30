package br.com.clientes.api.controller;

import br.com.clientes.api.dto.response.ClienteResponse;
import br.com.clientes.domain.exception.NotFoundException;
import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("v1/clientes")
public class ClientesController {
    private static final Faker faker = new Faker(new Locale("pt", "BR"));

    private static Map<String, ClienteResponse> clientes = new HashMap<>();
    static {
        for (int i = 0; i < 10; i++) {
            String id = faker.idNumber().valid();
            clientes.put(id, new ClienteResponse(id, faker.name().name()));
        }
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponse>> buscarTodos() {
        return ResponseEntity.ok(clientes.values().stream().toList());
    }

    @GetMapping("{id}")
    public ResponseEntity<ClienteResponse> buscarPorId(@PathVariable String id) {
        return ResponseEntity.ok(Optional
                .ofNullable(clientes.get(id))
                .orElseThrow(() -> new NotFoundException(id)));
    }
}
