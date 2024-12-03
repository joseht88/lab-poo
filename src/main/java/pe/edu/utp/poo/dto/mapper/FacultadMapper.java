package pe.edu.utp.poo.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import pe.edu.utp.poo.dto.FacultadDTO;
import pe.edu.utp.poo.dto.mapper.common.GenericMapper;
import pe.edu.utp.poo.modelo.Facultad;

@Mapper(componentModel = "spring")
public interface FacultadMapper extends GenericMapper<FacultadDTO, Facultad> {
	FacultadMapper MAP = Mappers.getMapper(FacultadMapper.class);
}
