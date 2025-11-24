package pe.edu.utp.poo.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.utp.poo.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {

    /**
     * Este metodo busca por DNI
     *
     * @param dni Recibe como parametro DNI
     * @return retorna el objeto persona
     */
    Optional<Persona> findByDni(String dni);

    Optional<Persona> findTop1ByDni(String dni);

    List<Persona> findByFeNacimientoBetween(LocalDate feInicio, LocalDate feFin);

}
