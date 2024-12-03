package pe.edu.utp.poo.controller;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pe.edu.utp.poo.dto.FacultadDTO;
import pe.edu.utp.poo.service.FacultadService;
/** Validation
 * https://medium.com/@himani.prasad016/validations-in-spring-boot-e9948aa6286b
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/facultad")
public class FacultadController {

	private final FacultadService service;

	@GetMapping
	public ResponseEntity<List<FacultadDTO>> getAll() {
		return ResponseEntity.ok(service.getAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<FacultadDTO> getById(@PathVariable(required = true) Integer id) {
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
	public ResponseEntity<Object> registrar(@RequestBody @Valid FacultadDTO dto, BindingResult result) {
		if (result.hasErrors())
			return ResponseEntity.badRequest().body(result);
		try {
			var rs = service.create(dto);
			return ResponseEntity.status(HttpStatus.CREATED).body(rs);
		} catch (DataAccessException e) {
			log.error(e.getLocalizedMessage());
			return ResponseEntity.internalServerError().body("Error al registrar facultad!");
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<FacultadDTO> editar(@PathVariable(required = true) Integer id, @RequestBody FacultadDTO dto) {
		try {
			var e = service.findById(id);
			if (e.isPresent()) {
				var up = service.update(e.get(), dto);
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
			var e = service.findById(id);
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
