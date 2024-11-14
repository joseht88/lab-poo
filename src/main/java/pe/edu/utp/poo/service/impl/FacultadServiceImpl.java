package pe.edu.utp.poo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import pe.edu.utp.poo.modelo.Facultad;
import pe.edu.utp.poo.repository.FacultadRepository;
import pe.edu.utp.poo.service.FacultadService;

@RequiredArgsConstructor
@Service
public class FacultadServiceImpl implements FacultadService {
	
	private final FacultadRepository repo;

	@Transactional(readOnly = true)
	@Override
	public Optional<Facultad> getById(Integer id) {
		var value = repo.findById(id);
		if (value.isPresent())
			return value;
		return Optional.empty();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Facultad> getAll() {
		return repo.findAll();
	}

	@Transactional
	@Override
	public Facultad create(Facultad p) {
		return repo.save(p);
	}

	@Transactional
	@Override
	public Facultad update(Facultad p) {
		return repo.save(p);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) {
		repo.deleteById(id);
	}

}
