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
import pe.edu.utp.poo.modelo.Estudiante;
import pe.edu.utp.poo.service.EstudianteService;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/estudiante")
public class EstudianteController {
	
    private final EstudianteService service;

    @GetMapping
    public ResponseEntity<List<Estudiante>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> getById(@PathVariable(required = true) Integer id) {
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
    public ResponseEntity<Estudiante> registrar(@RequestBody Estudiante p) {
        try {
            var res = service.create(p);
            return ResponseEntity.status(HttpStatus.CREATED).body(res);
        } catch (DataAccessException e) {
            log.error(e.getLocalizedMessage());
        }
        return ResponseEntity.badRequest().build();

    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Estudiante> editar(@PathVariable(required = true) Integer id, @RequestBody Estudiante p) {
        try {
        	var e = service.getById(id);
        	if(e.isPresent()) {
        		var up = e.get();
        		//estudiante
        		up.setCodigo(p.getCodigo());
        		up.setEmail(p.getEmail());
        		up.setActivo(true);
        		//persona
        		up.setDni(p.getDni());
        		up.setNombre(p.getNombre());
        		up.setApellido1(p.getApellido1());
        		up.setApellido2(p.getApellido2());
        		up.setEmail(p.getEmail());
        		up.setFeNacimiento(p.getFeNacimiento());
        		
        		var rs = service.create(up);
        		return ResponseEntity.status(HttpStatus.CREATED).body(rs);
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
