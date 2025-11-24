package pe.edu.utp.poo.model;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.edu.utp.poo.config.Auditor;

/**
 * Clase Persona
 * @author Jose Bustamante
 * @version 1.0
 * @see <a href="https://medium.com/analytics-vidhya/jpa-hibernate-entity-inheritance-1f6aa7ea2eea">...</a>
 */

@Entity
@Table(name = "tbl_persona")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Persona extends Auditor<String> implements Serializable {

    private static final long serialVersionUID = 183679305041137411L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String dni;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String email;
    @Column(name = "fenacimiento")
    private LocalDate feNacimiento;
    @Transient
    private int edad;

    public Persona(String dni, String nombre, String apellido1, String apellido2, String email, LocalDate feNacimiento) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.email = email;
        this.feNacimiento = feNacimiento;
    }
}
