package pe.edu.utp.poo.service;

import java.util.List;
import java.util.Optional;

import pe.edu.utp.poo.model.Carrera;

public interface CarreraService {
   
	public Optional<Carrera> getById(Integer id);

    public List<Carrera> getAll();

    public Carrera create(Carrera p);

    public Carrera update(Carrera p);

    public void deleteById(Integer id);
}
