package pe.edu.utp.poo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.utp.poo.model.Facultad;

import java.util.List;

public interface FacultadRepository extends JpaRepository<Facultad, Integer> {
    List<Facultad> findByActivoTrue();
}
