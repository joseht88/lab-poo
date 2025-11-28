package pe.edu.utp.poo.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.utp.poo.model.Persona;
import pe.edu.utp.poo.repository.PersonaRepository;
import pe.edu.utp.poo.service.PersonaService;

@Slf4j //para usar logger -> usar log para llamar a sus metodos
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
        try {
            Optional<Persona> person = repo.findById(id);
            if (person.isPresent()) {
                log.debug("Persona encontrada: ID {}", id);
            } else {
                log.debug("Persona no encontrada con ID: {}", id);
            }
            return person;
        } catch (DataAccessException e) {
            // Errores específicos de acceso a datos
            log.error("Error de acceso a datos al buscar persona con ID {}: {}", id, e.getMessage());
            return Optional.empty();
        } catch (Exception e) {
            // Cualquier otro error inesperado
            log.error("Error inesperado al buscar persona con ID {}: {}", id, e.getMessage(), e);
            return Optional.empty();
        }
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
        try {
            Optional<Persona> person = repo.findByDni(dni);
            if (person.isPresent()) {
                log.debug("Persona encontrada con DNI: {}", dni);
            } else {
                log.debug("No se encontró persona con DNI: {}", dni);
            }
            return person;
        } catch (DataAccessException e) {
            // Errores específicos de acceso a datos
            log.error("Error de acceso a datos al buscar persona por DNI {}: {}", dni, e.getMessage());
            return Optional.empty();
        } catch (Exception e) {
            // Cualquier otro error inesperado
            log.error("Error inesperado al buscar persona por DNI {}: {}", dni, e.getMessage(), e);
            return Optional.empty();
        }
    }

    /**
     * Metodo para obtener todos los objetos
     *
     * @return Lista de objetos de personas
     */
    @Transactional(readOnly = true)
    @Override
    public List<Persona> getAll() {
        try {
            //uso de var  en assignments simples y obvios
            var persons = repo.findAll();
            log.debug("Total de personas encontradas: {}", persons.size());

            return persons;
        } catch (DataAccessException e) {
            // Errores específicos de acceso a datos
            log.error("Error de acceso a datos al obtener todas las personas: {}", e.getMessage());
            return Collections.emptyList();
        } catch (Exception e) {
            // Cualquier otro error inesperado
            log.error("Error inesperado al obtener todas las personas: {}", e.getMessage(), e);
            return Collections.emptyList();
        }
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
        try {
            //uso de var  en assignments simples y obvios
            var persons = repo.findByFeNacimientoBetween(feInicio, feFin);
            log.debug("Encontradas {} personas en el rango de fechas", persons.size());

            return persons;
        } catch (DataAccessException e) {
            // Errores específicos de acceso a datos
            log.error("Error de acceso a datos al buscar por fecha de nacimiento {} - {}: {}", feInicio, feFin, e.getMessage());
            return Collections.emptyList();
        } catch (Exception e) {
            // Cualquier otro error inesperado
            log.error("Error inesperado al buscar por fecha de nacimiento {} - {}: {}", feInicio, feFin, e.getMessage(), e);
            return Collections.emptyList();
        }
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
        try {
            // Verificar que no exista otra persona con el mismo DNI
            Optional<Persona> existente = repo.findByDni(p.getDni().trim());
            if (existente.isPresent()) {
                throw new IllegalArgumentException("Ya existe una persona con DNI: " + p.getDni());
            }
            // Asegurar que es una nueva entidad (id null)
            p.setId(null);
            // Esto solo es para el caso de Auditor , si implementara security debera modificar en la configuracion para que sea automatico
            p.setCreatedBy("admin");
            p.setCreatedDate(LocalDateTime.now());

            Persona person = repo.save(p);
            return person;
        } catch (IllegalArgumentException e) {
            log.warn("Error de validación al crear persona: {}", e.getMessage());
            throw e; // Relanzar para que el controlador lo maneje
        } catch (DataIntegrityViolationException e) {
            log.error("Violación de integridad de datos al crear persona: {}", e.getMessage());
            throw new RuntimeException("Error de integridad de datos: " + e.getMessage(), e);
        } catch (DataAccessException e) {
            log.error("Error de acceso a datos al crear persona: {}", e.getMessage());
            throw new RuntimeException("Error de base de datos al crear persona", e);
        } catch (Exception e) {
            log.error("Error inesperado al crear persona: {}", e.getMessage(), e);
            throw new RuntimeException("Error interno al crear persona", e);
        }
    }

    /**
     * Metodo para actualizar el objeto persona
     *
     * @param p Parámetro objeto persona a actualizar
     * @return Retorna objeto persona actualizado
     */
    @Transactional
    @Override
    public Persona update(Persona old, Persona p) {
        try {
            // Validar que el DNI no esté duplicado (si se está modificando)
            if (p.getDni() != null && !p.getDni().equals(old.getDni())) {
                Optional<Persona> personaConMismoDni = repo.findByDni(p.getDni().trim());
                if (personaConMismoDni.isPresent() &&
                        !personaConMismoDni.get().getId().equals(p.getId())) {
                    throw new IllegalArgumentException("Ya existe otra persona con DNI: " + p.getDni());
                }
            }

            // Actualizar fecha de modificación si existe el campo solo para el auditor
            old.setModifiedBy("admin");
            old.setModifiedDate(LocalDateTime.now());

            // Actualizar en el objeto
            old.setDni(p.getDni());
            old.setNombre(p.getNombre());
            old.setApellido1(p.getApellido1());
            old.setApellido2(p.getApellido2());
            old.setEmail(p.getEmail());
            old.setFeNacimiento(p.getFeNacimiento());

            return repo.save(p);
        } catch (IllegalArgumentException e) {
            log.warn("Error de validación al actualizar persona: {}", e.getMessage());
            throw e;
        } catch (DataAccessException e) {
            log.error("Error de acceso a datos al actualizar persona: {}", e.getMessage());
            throw new RuntimeException("Error de base de datos al actualizar persona", e);
        } catch (Exception e) {
            log.error("Error inesperado al actualizar persona: {}", e.getMessage(), e);
            throw new RuntimeException("Error interno al actualizar persona", e);
        }
    }

    /**
     * Metodo para eliminar el objeto persona por Id
     *
     * @param id Parametro Id de la persona
     */
    @Transactional
    @Override
    public void deleteById(Integer id) {
        try {
            repo.deleteById(id);
        } catch (IllegalArgumentException e) {
            log.warn("Error de validación al eliminar persona: {}", e.getMessage());
            throw e;
        } catch (DataAccessException e) {
            log.error("Error de acceso a datos al eliminar persona con ID {}: {}", id, e.getMessage());
            throw new RuntimeException("Error de base de datos al eliminar persona", e);
        } catch (Exception e) {
            log.error("Error inesperado al eliminar persona con ID {}: {}", id, e.getMessage(), e);
            throw new RuntimeException("Error interno al eliminar persona", e);
        }
    }
}
