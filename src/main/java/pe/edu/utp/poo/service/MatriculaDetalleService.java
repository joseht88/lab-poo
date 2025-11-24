package pe.edu.utp.poo.service;

import java.util.List;
import java.util.Optional;

import pe.edu.utp.poo.model.MatriculaDetalle;

public interface MatriculaDetalleService {
	
	Optional<MatriculaDetalle> getById(Integer id);

	List<MatriculaDetalle> getAll();

	MatriculaDetalle create(MatriculaDetalle p);

	MatriculaDetalle update(MatriculaDetalle p);

	void deleteById(Integer id);
}
