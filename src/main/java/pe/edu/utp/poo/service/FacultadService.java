package pe.edu.utp.poo.service;

import java.util.List;
import java.util.Optional;

import pe.edu.utp.poo.modelo.Facultad;

public interface FacultadService {
	
    public Optional<Facultad> getById(Integer id);

    public List<Facultad> getAll();

    public Facultad create(Facultad p);

    public Facultad update(Facultad p);

    public void deleteById(Integer id);
}
