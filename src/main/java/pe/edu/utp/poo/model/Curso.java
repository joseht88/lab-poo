package pe.edu.utp.poo.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

/**
 * Clase Curso que dicta un docente
 *
 * @author Jose Bustamante
 * @version 1.0
 */

@Entity
@Table(name = "tbl_curso")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
