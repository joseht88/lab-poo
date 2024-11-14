package pe.edu.utp.poo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.utp.poo.modelo.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {

	public Optional<Persona> findByDni(String dni);

}
