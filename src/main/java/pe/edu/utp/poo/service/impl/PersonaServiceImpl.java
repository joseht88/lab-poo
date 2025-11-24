package pe.edu.utp.poo.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.utp.poo.model.Persona;
import pe.edu.utp.poo.repository.PersonaRepository;
import pe.edu.utp.poo.service.PersonaService;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaRepository repo;

    /**
     * Metodo para obtener un objeto persona por Id
     *
     * @param id Parametro Id del objeto a buscar
     * @return Objero persona encontrada en Optional
     */
    @Transactional(readOnly = true)
    @Override
    public Optional<Persona> getById(Integer id) {
        var value = repo.findById(id);
        if (value.isPresent())
            return value;
        return Optional.empty();
    }

    /**
     * Metodo para obtener
     *
     * @param dni Parametro numero DNI en formato cadena de la persona
     * @return Retorna el objeto persona encontrado en Optional
     */
    @Transactional(readOnly = true)
    @Override
    public Optional<Persona> getByDni(String dni) {
        return repo.findByDni(dni);
    }

    /**
     * Metodo para obtener todos los objetos
     *
     * @return Lista de objetos de personas
     */
    @Transactional(readOnly = true)
    @Override
    public List<Persona> getAll() {
        return repo.findAll();
    }

    /**
     * Metodo para obtener a las personas por fecha de nacimiento
     *
     * @param feInicio Parametro fecha de nacimiento inicial
     * @param feFin    Parametro fecha de nacimiento final
     * @return Lista de objetos persona encontrados
     */
    @Transactional(readOnly = true)
    @Override
    public List<Persona> getByFeNacimiento(LocalDate feInicio, LocalDate feFin) {
        return repo.findByFeNacimientoBetween(feInicio, feFin);
    }

    /**
     * Metodo para registar el objeto persona
     *
     * @param p Es el objeto a guardar
     * @return Retorna el objeto persona registrado
     */
    @Transactional
    @Override
    public Persona create(Persona p) {
        return repo.save(p);
    }

    /**
     * Metodo para actualizar el objeto persona
     *
     * @param p Parámetro objeto persona a actualizar
     * @return Retorna objeto persona actualizado
     */
    @Transactional
    @Override
    public Persona update(Persona p) {
        return repo.save(p);
    }

    /**
     * Metodo para eliminar el objeto persona por Id
     *
     * @param id Parametro Id de la persona
     */
    @Transactional
    @Override
    public void deleteById(Integer id) {
        repo.deleteById(id);
    }
}
