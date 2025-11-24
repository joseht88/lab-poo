package pe.edu.utp.poo.collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pe.edu.utp.poo.model.Persona;
import pe.edu.utp.poo.util.collection.IPersonaBaseDatos;
import pe.edu.utp.poo.util.collection.PersonaBDList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonaBDListTest {

    private IPersonaBaseDatos baseDatos;
    private Persona p1;
    private Persona p2;
    private List<Persona> listaEsperada;

    @BeforeEach
    void setUp() {
        this.baseDatos = new PersonaBDList();
        p1 = new Persona(null, "40597166", "Jose", "Bustamante", "Romero", "c29692@utp.edu.pe", LocalDate.of(1980, 8, 8), 0);
        p2 = new Persona(null, "40000007", "Joel", "Garcia", "Lua", "c29000@utp.edu.pe", LocalDate.of(1990, 12, 25), 0);
        this.listaEsperada = new ArrayList<>();
    }

    @Test
    void save() {
        Persona resultadoEsperado = this.baseDatos.save(p1);
        assertEquals(resultadoEsperado.getDni(), "40597166");
        Persona resultadoActual = this.baseDatos.getId(1);
        assertEquals(resultadoEsperado, resultadoActual);
    }

    @Test
    void update() {
        p2.setDni("40506070");
        Persona resultadoEsperado = this.baseDatos.update(p2);
        assertEquals(resultadoEsperado.getDni(), "40597166");
    }

    @Test
    void getId() {
        Persona p = this.baseDatos.save(p1);
        Persona resultadoEsperado = this.baseDatos.getId(p.getId());
        assertNotNull(resultadoEsperado);
        assertEquals(resultadoEsperado.getId(), p.getId());
    }

    @Test
    void getAll() {
        this.baseDatos.save(p1);
        this.baseDatos.save(p2);
        this.listaEsperada = this.baseDatos.getAll();
        assertEquals(listaEsperada.size(), 2);
    }

    @Test
    void delete() {
        Persona rs1 = this.baseDatos.save(p1);
        Persona rs2 = this.baseDatos.save(p2);
        this.baseDatos.delete(rs1.getId());
        Persona resultadoEsperado = this.baseDatos.getId(rs1.getId());
        assertNull(resultadoEsperado);
        assertEquals(this.baseDatos.getAll().size(), 1);
    }

    @Test
    void deleteIterator() {
        Persona rs1 = this.baseDatos.save(p1);
        Persona rs2 = this.baseDatos.save(p2);
        this.baseDatos.deleteIterator(rs1.getId());
        Persona resultadoEsperado = this.baseDatos.getId(rs1.getId());
        assertNull(resultadoEsperado);
        assertEquals(this.baseDatos.getAll().size(), 1);
    }
}