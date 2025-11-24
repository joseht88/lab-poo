package pe.edu.utp.poo.service;

import java.util.List;
import java.util.Optional;

import pe.edu.utp.poo.model.Curso;

public interface CursoService {
	
    Optional<Curso> getById(Integer id);

    List<Curso> getAll();

    Curso create(Curso p);

    Curso update(Curso p);

    void deleteById(Integer id);
}
