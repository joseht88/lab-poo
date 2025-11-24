package pe.edu.utp.poo.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import lombok.*;

/**
 * Clase Matricula universitaria
 * @author Jose Bustamante
 * @version 1.0
 */
@Entity
@Table(name = "tbl_matricula")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Matricula implements Serializable {

    private static final long serialVersionUID = -3078312584967845975L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String semestre;
    private Integer anio;
    private LocalDate inicio;
    private LocalDate fin;
    private boolean activo;

    @ManyToOne
    @JoinColumn(name = "estudiante_id", referencedColumnName = "id")
    private Estudiante estudiante;

    @OneToMany(mappedBy = "matricula", cascade = CascadeType.ALL)
    private List<MatriculaDetalle> cargaAcademica;
}
