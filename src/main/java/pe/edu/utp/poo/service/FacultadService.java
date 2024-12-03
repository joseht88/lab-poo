package pe.edu.utp.poo.service;

import java.util.List;
import java.util.Optional;

import pe.edu.utp.poo.dto.FacultadDTO;
import pe.edu.utp.poo.modelo.Facultad;

public interface FacultadService {
	
    public Optional<FacultadDTO> getById(Integer id);
    
    public Optional<Facultad> findById(Integer id);

    public List<FacultadDTO> getAll();

    public FacultadDTO create(FacultadDTO dto);

    public FacultadDTO update(Facultad e, FacultadDTO dto);

    public void deleteById(Integer id);
}
