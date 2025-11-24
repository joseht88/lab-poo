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
import pe.edu.utp.poo.model.Carrera;
import pe.edu.utp.poo.service.CarreraService;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/carrera")
public class CarreraController {
	
    private final CarreraService service;

    @GetMapping
    public ResponseEntity<List<Carrera>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carrera> getById(@PathVariable(required = true) Integer id) {
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
    public ResponseEntity<Carrera> registrar(@RequestBody Carrera p) {
        try {
            var res = service.create(p);
            return ResponseEntity.status(HttpStatus.CREATED).body(res);
        } catch (DataAccessException e) {
            log.error(e.getLocalizedMessage());
        }
        return ResponseEntity.badRequest().build();

    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Carrera> editar(@PathVariable(required = true) Integer id, @RequestBody Carrera p) {
        try {
        	var e = service.getById(id);
        	if(e.isPresent()) {
        		e.get().setNombre(p.getNombre());
        		e.get().setFacultad(p.getFacultad());
        		e.get().setCreditos(p.getCreditos());
        		e.get().setDuracion(p.getDuracion());
        		e.get().setActivo(p.isActivo());
        		
        		var up = service.create(e.get());
        		return ResponseEntity.status(HttpStatus.CREATED).body(up);
        	}
        } catch (DataAccessException e) {
            log.error(e.getLocalizedMessage());
        }
        return ResponseEntity.badRequest().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable(required = true) Integer id) {
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
