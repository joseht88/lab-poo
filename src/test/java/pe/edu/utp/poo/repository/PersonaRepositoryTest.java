package pe.edu.utp.poo.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import pe.edu.utp.poo.model.Persona;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@DataJpaTest()
@TestPropertySource(properties = {
        "spring.sql.init.mode=never",
        "spring.jpa.hibernate.ddl-auto=create-drop"
})
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class PersonaRepositoryTest {

    @Autowired
    private PersonaRepository repo;
    private Persona p1;
    private Persona p2;
    List<Persona> personas;

    @BeforeEach
    void setUp() {
        this.p1 = new Persona("40597166", "Jose", "Bustamante", "Romero", "c29692@utp.edu.pe", LocalDate.of(1980, 8, 8));
        p1.setCreatedBy("admin");
        p1.setCreatedDate(LocalDateTime.now());
        this.p2 = new Persona("40597167", "Miguel", "Bustamante", "Romero", "c29693@utp.edu.pe", LocalDate.of(1980, 9, 8));
        p2.setCreatedBy("admin");
        p2.setCreatedDate(LocalDateTime.now());
        this.personas = List.of(p1, p2);
    }

    @Test
    void registrarPersonaTest() {
        Persona rsEsperado = repo.save(p1);
        assertNotNull(rsEsperado);
        assertNotNull(rsEsperado.getId());
        assertEquals(rsEsperado.getDni(), p1.getDni());
        System.out.println(rsEsperado.toString());
    }

    @Test
    void buscarPersonaByIdTest() {
        Persona persona = repo.save(p1);
        Persona rsEsperado = repo.getById(persona.getId());
        assertEquals(rsEsperado.getId(), persona.getId());
        assertEquals(rsEsperado.getDni(), p1.getDni());
    }

    @Test
    void buscarPersonaPorDniTest() {
        Persona persona = repo.save(p1);
        Optional<Persona> rsEsperado = repo.findByDni(persona.getDni());
        assertEquals(rsEsperado.isPresent(), true);
        assertEquals(rsEsperado.get().getDni(), p1.getDni());
    }

    @Test
    void buscarPersonaPorFechaNacimientoTest() {
        repo.saveAll(this.personas);
        LocalDate inicio = LocalDate.of(1980, 8, 8);
        LocalDate fin = LocalDate.of(1980, 9, 8);
        List<Persona> rsEsperado = repo.findByFeNacimientoBetween(inicio, fin);
        assertTrue(rsEsperado.isEmpty() == false);
        assertEquals(rsEsperado.size(), 2);
    }

    @Test
    void buscarPersonasTodoTest() {
        repo.saveAll(this.personas);
        List<Persona> rsEsperado = repo.findAll();
        assertTrue(rsEsperado.size() == this.personas.size());
        assertEquals(rsEsperado.size(), 2);
    }

    @Test
    void actualizarPersonaTest() {
        var lista = repo.saveAll(this.personas);
        Optional<Persona> actual = repo.findById(lista.get(0).getId());
        actual.get().setDni("80808080");
        actual.get().setEmail("U80808080@upt.edu.pe");
        actual.get().setNombre("Nuevito");
        Persona actualizado = repo.save(actual.get());
        Optional<Persona> rsEsperado = repo.findByDni("80808080");
        assertTrue(rsEsperado.isPresent());
        assertEquals(rsEsperado.get().getDni(), "80808080");
        assertEquals(rsEsperado.get().getEmail(), "U80808080@upt.edu.pe");
        assertEquals(rsEsperado.get().getNombre(), "Nuevito");
    }

    @Test
    void eliminarPersonaTest() {
        var lista = repo.saveAll(this.personas);
        var id = lista.get(0).getId();
        repo.deleteById(id);
        Optional<Persona> rsEsperado = repo.findById(id);
        assertFalse(rsEsperado.isPresent());
        assertTrue(repo.findAll().size() == 1);
    }
}
