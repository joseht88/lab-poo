package pe.edu.utp.poo.service;

import java.util.List;
import java.util.Optional;

import pe.edu.utp.poo.model.Matricula;

public interface MatriculaService {
	
    Optional<Matricula> getById(Integer id);

    List<Matricula> getAll();

    Matricula create(Matricula p);

    Matricula update(Matricula p);

    void deleteById(Integer id);
}
