package pe.edu.utp.poo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import pe.edu.utp.poo.model.Carrera;
import pe.edu.utp.poo.repository.CarreraRepository;
import pe.edu.utp.poo.service.CarreraService;

@RequiredArgsConstructor
@Service
public class CarreraServiceImpl implements CarreraService {

	private final CarreraRepository repo;

	@Transactional(readOnly = true)
	@Override
	public Optional<Carrera> getById(Integer id) {
		var value = repo.findById(id);
		if (value.isPresent())
			return value;
		return Optional.empty();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Carrera> getAll() {
		return repo.findAll();
	}

	@Transactional
	@Override
	public Carrera create(Carrera p) {
		return repo.save(p);
	}

	@Transactional
	@Override
	public Carrera update(Carrera p) {
		return repo.save(p);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) {
		repo.deleteById(id);
	}
}
