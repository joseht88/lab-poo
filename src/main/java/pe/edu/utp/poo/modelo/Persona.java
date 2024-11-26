package pe.edu.utp.poo.modelo;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Jose Bustamante
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED) //https://medium.com/analytics-vidhya/jpa-hibernate-entity-inheritance-1f6aa7ea2eea
@Table(name = "tbl_persona")
@Getter
@Setter
public class Persona implements Serializable {
	
	private static final long serialVersionUID = 183679305041137411L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String dni;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String email;
	private LocalDate feNacimiento;
	@Transient
	private int edad;

}
