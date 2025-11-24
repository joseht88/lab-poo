package pe.edu.utp.poo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import pe.edu.utp.poo.dto.FacultadDTO;
import pe.edu.utp.poo.dto.mapper.FacultadMapper;
import pe.edu.utp.poo.model.Facultad;
import pe.edu.utp.poo.repository.FacultadRepository;
import pe.edu.utp.poo.service.FacultadService;

@RequiredArgsConstructor
@Service
public class FacultadServiceImpl implements FacultadService {
	
	private final FacultadRepository repo;

	@Transactional(readOnly = true)
	@Override
	public Optional<FacultadDTO> getById(Integer id) {
		var value = repo.findById(id);
		if (value.isPresent())
			return Optional.of(FacultadMapper.MAP.entityToDto(value.get()));
		return Optional.empty();
	}
	
	@Transactional(readOnly = true)
	@Override
	public Optional<Facultad> findById(Integer id) {
		return repo.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<FacultadDTO> getAll() {
		return FacultadMapper.MAP.entityToDto(repo.findAll());
	}

	@Transactional
	@Override
	public FacultadDTO create(FacultadDTO dto) {
		var e = repo.save(FacultadMapper.MAP.dtoToEntity(dto));
		return FacultadMapper.MAP.entityToDto(e);
	}

	@Transactional
	@Override
	public FacultadDTO update(Facultad e, FacultadDTO dto) {
		e.setNombre(dto.nombre());
		e.setActivo(dto.activo());
		var rs = repo.save(e);
		return FacultadMapper.MAP.entityToDto(rs);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) {
		repo.deleteById(id);
	}

}
