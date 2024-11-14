package pe.edu.utp.poo.service;

import java.util.List;
import java.util.Optional;

import pe.edu.utp.poo.modelo.Curso;

public interface CursoService {
	
    public Optional<Curso> getById(Integer id);

    public List<Curso> getAll();

    public Curso create(Curso p);

    public Curso update(Curso p);

    public void deleteById(Integer id);
}
