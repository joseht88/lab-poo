package pe.edu.utp.poo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.utp.poo.model.Carrera;

import java.util.List;

public interface CarreraRepository extends JpaRepository<Carrera, Integer> {
    List<Carrera> findByActivoTrue();
}
