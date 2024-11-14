package pe.edu.utp.poo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import pe.edu.utp.poo.modelo.Persona;
import pe.edu.utp.poo.repository.PersonaRepository;
import pe.edu.utp.poo.service.PersonaService;

@RequiredArgsConstructor
@Service
public class PersonaServiceImpl implements PersonaService {
	
	private PersonaRepository repo;

	@Transactional(readOnly = true)
	@Override
	public Optional<Persona> getById(Integer id) {
		var value = repo.findById(id);
		if (value.isPresent())
			return value;
		return Optional.empty();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Persona> getAll() {
		return repo.findAll();
	}

	@Transactional
	@Override
	public Persona create(Persona p) {
		return repo.save(p);
	}

	@Transactional
	@Override
	public Persona update(Persona p) {
		return repo.save(p);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) {
		repo.deleteById(id);
	}
}
