package pe.edu.utp.poo.service;

import java.util.List;
import java.util.Optional;

import pe.edu.utp.poo.modelo.Persona;

public interface PersonaService {
	
	public Optional<Persona> getById(Integer id);

	public List<Persona> getAll();

	public Persona create(Persona p);

	public Persona update(Persona p);

	public void deleteById(Integer id);
}
