package pe.edu.utp.poo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import pe.edu.utp.poo.model.Persona;

public interface PersonaService {
	
	Optional<Persona> getById(Integer id);

	Optional<Persona> getByDni(String dni);

	List<Persona> getByFeNacimiento(LocalDate feInicio, LocalDate feFin);

	List<Persona> getAll();

	Persona create(Persona p);

	Persona update(Persona old, Persona p);

	void deleteById(Integer id);
}
