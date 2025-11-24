package pe.edu.utp.poo.service;

import java.util.List;
import java.util.Optional;

import pe.edu.utp.poo.dto.FacultadDTO;
import pe.edu.utp.poo.model.Facultad;

public interface FacultadService {
	
    Optional<FacultadDTO> getById(Integer id);
    
    Optional<Facultad> findById(Integer id);

    List<FacultadDTO> getAll();

    FacultadDTO create(FacultadDTO dto);

    FacultadDTO update(Facultad e, FacultadDTO dto);

    void deleteById(Integer id);
}
