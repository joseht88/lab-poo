package pe.edu.utp.poo.model;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase Estudiante universitari0
 * @author Jose Bustamante
 * @version 1.0
 */

@Entity
@Table(name = "tbl_estudiante")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@PrimaryKeyJoinColumn(referencedColumnName = "id") //https://medium.com/analytics-vidhya/jpa-hibernate-entity-inheritance-1f6aa7ea2eea
public class Estudiante extends Persona implements Serializable {

	private static final long serialVersionUID = -4142188013780942981L;
	
	private String codigo;
    @Column(name = "emailutp")
    private String emailUtp;
    private LocalDate inicio;
    private boolean activo;

}