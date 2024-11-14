package pe.edu.utp.poo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.utp.poo.modelo.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {

	public List<Estudiante> findByActivo(boolean activo);

	public Optional<Estudiante> findByIdAndActivo(Integer id, boolean activo);

	public Optional<Estudiante> findByIdAndActivoTrue(Integer id);
}
