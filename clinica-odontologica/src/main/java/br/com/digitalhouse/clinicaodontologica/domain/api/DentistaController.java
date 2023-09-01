package br.com.digitalhouse.clinicaodontologica.domain.api;

import br.com.digitalhouse.clinicaodontologica.domain.entity.Dentista;
import br.com.digitalhouse.clinicaodontologica.domain.service.DentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("dentistas")
public class DentistaController {

    private final DentistaService dentistaService;
    @Autowired
    public DentistaController(DentistaService dentistaService) {
        this.dentistaService = dentistaService;
    }

    @GetMapping("{id}")
    Dentista buscarPorId(@PathVariable Integer id) {
        return dentistaService.buscarPorId(id).orElseThrow();
    }

    @PostMapping
    ResponseEntity<Dentista> criarDentista(@RequestBody Dentista dentista) {
        return ResponseEntity.status(201)
                .header("usuarioId", "id")
                .body(dentistaService.criarDentista(dentista));
    }

    @PutMapping("{id}")
    Dentista atualizarDentista(@PathVariable Integer id, @RequestBody Dentista dentista) {
        dentista.setId(id);
        return dentistaService.atualizarDentista(dentista);
    }
}
