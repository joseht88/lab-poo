package pe.edu.utp.poo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.utp.poo.model.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {

	List<Estudiante> findByActivo(boolean activo);

	List<Estudiante> findByActivoTrue();

	Optional<Estudiante> findByIdAndActivo(Integer id, boolean activo);

	Optional<Estudiante> findByIdAndActivoTrue(Integer id);
}
