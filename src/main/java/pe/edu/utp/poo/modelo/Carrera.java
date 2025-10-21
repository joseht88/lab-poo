package pe.edu.utp.poo.modelo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Builder
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@AllArgsConstructor @NoArgsConstructor
@Table(name = "tbl_carrera")
public class Carrera implements Serializable {

	private static final long serialVersionUID = 1626681494940036126L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	@Column(name = "duracion_anios")
	private int duracion;
	private int creditos;
	private boolean activo;

	// https://www.arquitecturajava.com/jpa-manytoone/
	@JsonIgnoreProperties(value = "carreras")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_facultad", referencedColumnName = "id")
	private Facultad facultad;

}
