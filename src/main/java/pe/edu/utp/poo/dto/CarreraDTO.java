package pe.edu.utp.poo.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public record CarreraDTO(Integer id, 
		String nombre,
		@Min(value = 1, message = "La duracion no debe ser inferior a 1 año")
	    @Max(value = 6, message = "La duracion no debe ser superior a 6 años")
		int duracion, 
		int creditos, 
		boolean activo, 
		FacultadDTO facultad) {

}
