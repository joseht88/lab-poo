package pe.edu.utp.poo.modelo;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
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
@Entity
@Table(name = "tbl_estudiante")
@Getter
@Setter
@Builder
@AllArgsConstructor @NoArgsConstructor
@PrimaryKeyJoinColumn(referencedColumnName = "id") //https://medium.com/analytics-vidhya/jpa-hibernate-entity-inheritance-1f6aa7ea2eea
public class Estudiante extends Persona implements Serializable {

	private static final long serialVersionUID = -4142188013780942981L;
	
	private String codigo;
    private String emailUtp;
    private boolean activo;

}