package pe.edu.utp.poo.controller;

import java.util.List;
import java.util.Optional;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pe.edu.utp.poo.model.Persona;
import pe.edu.utp.poo.service.PersonaService;

@Tag(name = "Personas", description = "Servicios que consume la aplicacion")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/persona")
public class PersonaController {

    private final PersonaService service;

    @GetMapping
    public ResponseEntity<List<Persona>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Persona> getById(@PathVariable(required = true) Integer id) {
        Optional<Persona> person = service.getById(id);
        if (person.isPresent()) {
            return ResponseEntity.ok(person.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Persona> registrar(@RequestBody Persona p) {
        try {
            var res = service.create(p);
            return ResponseEntity.status(HttpStatus.CREATED).body(res);
        } catch (DataAccessException e) {
            log.error(e.getLocalizedMessage());
        }
        return ResponseEntity.badRequest().build();

    }

    @PutMapping("/{id}")
    public ResponseEntity<Persona> editar(@PathVariable(required = true) Integer id, @RequestBody Persona p) {
        try {
            var e = service.getById(id);
            if (e.isPresent()) {
                var up = service.create(e.get());
                return ResponseEntity.status(HttpStatus.CREATED).body(up);
            }
            return ResponseEntity.notFound().build();
        } catch (DataAccessException e) {
            log.error(e.getLocalizedMessage());
            return ResponseEntity.badRequest().build();

        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable(required = true) Integer id) {
        try {
            var e = service.getById(id);
            if (e.isPresent()) {
                service.deleteById(e.get().getId());
                return ResponseEntity.ok().build();
            }
        } catch (DataAccessException e) {
            log.error(e.getLocalizedMessage());
        }
        return ResponseEntity.badRequest().build();
    }
}
