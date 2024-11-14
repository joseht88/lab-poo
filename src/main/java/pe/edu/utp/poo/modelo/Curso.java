package pe.edu.utp.poo.modelo;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Jose Bustamante
 */
@Builder
@Getter
@Setter
@Entity
@AllArgsConstructor @NoArgsConstructor
@Table(name = "tbl_curso")
public class Curso implements Serializable {

	private static final long serialVersionUID = -9131678571480265060L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private int creditos;
	private boolean activo;
	
	public Curso(Integer id) {
		this.id = id;
	}
	
}
