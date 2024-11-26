package pe.edu.utp.poo.service;

import java.util.List;
import java.util.Optional;

import pe.edu.utp.poo.modelo.Estudiante;

public interface EstudianteService {
	
	public Optional<Estudiante> getById(Integer id);

	public List<Estudiante> getAll();

	public Estudiante create(Estudiante e);
	
    public Estudiante update(Estudiante e);

    public void deleteById(Integer id);
}
