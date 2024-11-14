package pe.edu.utp.poo.service;

import java.util.List;
import java.util.Optional;

import pe.edu.utp.poo.modelo.Matricula;

public interface MatriculaService {
	
    public Optional<Matricula> getById(Integer id);

    public List<Matricula> getAll();

    public Matricula create(Matricula p);

    public Matricula update(Matricula p);

    public void deleteById(Integer id);
}
