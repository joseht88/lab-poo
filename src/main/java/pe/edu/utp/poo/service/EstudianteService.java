package pe.edu.utp.poo.service;

import java.util.List;
import java.util.Optional;

import pe.edu.utp.poo.model.Estudiante;

public interface EstudianteService {
	
	Optional<Estudiante> getById(Integer id);

	List<Estudiante> getAll();

	Estudiante create(Estudiante e);
	
    Estudiante update(Estudiante e);

    void deleteById(Integer id);
}
