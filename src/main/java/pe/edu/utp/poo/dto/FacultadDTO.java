package pe.edu.utp.poo.dto;

import java.util.List;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record FacultadDTO(Integer id, 
		@NotBlank @Size(min = 10, max = 250, message = "El nombre de contener mas de 10 y menos de 250 caracteres.") String nombre, 
		@AssertTrue(message = "Activo debe ser true") boolean activo,
		List<CarreraDTO> carreras
		) {

}
