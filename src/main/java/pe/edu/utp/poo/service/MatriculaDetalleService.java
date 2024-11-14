package pe.edu.utp.poo.service;

import java.util.List;
import java.util.Optional;

import pe.edu.utp.poo.modelo.MatriculaDetalle;

public interface MatriculaDetalleService {
	
	public Optional<MatriculaDetalle> getById(Integer id);

	public List<MatriculaDetalle> getAll();

	public MatriculaDetalle create(MatriculaDetalle p);

	public MatriculaDetalle update(MatriculaDetalle p);

	public void deleteById(Integer id);
}
