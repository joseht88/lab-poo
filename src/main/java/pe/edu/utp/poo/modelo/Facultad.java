package pe.edu.utp.poo.modelo;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@AllArgsConstructor @NoArgsConstructor
@Table(name = "tbl_facultad")
public class Facultad implements Serializable {

	private static final long serialVersionUID = -4119918149124890734L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private boolean activo;
    
    @JsonIgnoreProperties(value = "facultad")
    @OneToMany(mappedBy = "facultad", fetch = FetchType.LAZY)
    private List<Carrera> carreras;

	public Facultad(Integer id) {
		this.id = id;
	}
    
}
