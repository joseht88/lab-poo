package pe.edu.utp.poo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.utp.poo.modelo.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer> {

}
