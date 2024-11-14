package pe.edu.utp.poo.controller;

import java.util.List;

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
import pe.edu.utp.poo.modelo.Persona;
import pe.edu.utp.poo.service.PersonaService;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/persona")
public class PersonaController {
	
    private PersonaService service;

    @GetMapping
    public ResponseEntity<List<Persona>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Persona> getById(@PathVariable(required = true) Integer id) {
        try {
            var objeto = service.getById(id);
            if (objeto.isPresent()) {
                return ResponseEntity.ok(objeto.get());
            }
        } catch (DataAccessException e) {
            log.error(e.getLocalizedMessage());
        }
        return ResponseEntity.notFound().build();
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
    
    @PutMapping
    public ResponseEntity<Persona> editar(@PathVariable(required = true) Integer id, @RequestBody Persona p) {
        try {
        	var e = service.getById(id);
        	if(e.isPresent()) {
        		e.get().setDni(p.getDni());
        		e.get().setNombre(p.getNombre());
        		e.get().setApellido1(p.getApellido1());
        		e.get().setApellido2(p.getApellido2());
        		e.get().setEmail(p.getEmail());
        		e.get().setFeNacimiento(p.getFeNacimiento());
        		
        		var up = service.create(e.get());
        		return ResponseEntity.status(HttpStatus.CREATED).body(up);
        	}
        } catch (DataAccessException e) {
            log.error(e.getLocalizedMessage());
        }
        return ResponseEntity.badRequest().build();
    }
    
    @DeleteMapping
    public ResponseEntity<Object> eliminar(@PathVariable(required = true) Integer id, @RequestBody Persona p) {
        try {
        	var e = service.getById(id);
        	if(e.isPresent()) {
        		service.deleteById(e.get().getId());
        		return ResponseEntity.ok().build();
        	}
        } catch (DataAccessException e) {
            log.error(e.getLocalizedMessage());
        }
        return ResponseEntity.badRequest().build();
    }
}
