package pe.edu.utp.poo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import pe.edu.utp.poo.modelo.Estudiante;
import pe.edu.utp.poo.repository.EstudianteRepository;
import pe.edu.utp.poo.service.EstudianteService;

@RequiredArgsConstructor
@Service
public class EstudianteServiceImpl implements EstudianteService {

	private final EstudianteRepository repo;
	
	@Transactional(readOnly = true)
	@Override
	public Optional<Estudiante> getById(Integer id) {
		return repo.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Estudiante> getAll() {
		return repo.findAll();
	}

	@Transactional
	@Override
	public Estudiante create(Estudiante e) {
		return repo.save(e);
	}
	
	@Transactional
	@Override
	public Estudiante update(Estudiante e) {
		return repo.save(e);
	}

	@Override
	public void deleteById(Integer id) {
		repo.deleteById(id);
	}

}
