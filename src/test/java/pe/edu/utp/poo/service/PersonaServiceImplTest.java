package pe.edu.utp.poo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pe.edu.utp.poo.model.Persona;
import pe.edu.utp.poo.repository.PersonaRepository;
import pe.edu.utp.poo.service.impl.PersonaServiceImpl;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Jose Bustamante
 * @Date 3 may. 2024 - 11:10:14 a.m.
 */
/* @ExtendWith(MockitoExtension.class)
 * La clase de prueba se anota con @ExtendWith(MockitoExtension.class),
 * habilitando anotaciones de Mockito dentro del entorno de prueba.
 * Esto facilita la creación de simulacion y la inyección de simulacion
 * en la clase que se está probando sin configuración manual.
 */
@ExtendWith(MockitoExtension.class)
class PersonaServiceImplTest {
    /* @Mock private PersonaRepository repoMock
     * Crea una versión simulada de PersonaRepository, que es una dependencia de PersonaService.
     */
    @Mock
    private PersonaRepository repoMock;
    /* @InjectMocks private PersonaServiceImpl serviceMock;
     * Crea una instancia de PersonaServiceImpl e inyecta a los simulados PersonaRepository.
     */
    @InjectMocks
    private PersonaService serviceMock;

    private Persona p1;
    private Persona p2;
    private Persona savePersona;
    private Persona rsEsperado;
    private List<Persona> personas;

    /* Configuración de la prueba (método @BeforeEach):
     * Inicializa objetos comunes utilizados en múltiples pruebas,
     * como una muestra objeto Producto y una lista de libros,
     * para evitar la repetición en cada método de prueba.
     */
    @BeforeEach
    void setUp() {
        this.p1 = new Persona("40597166", "Jose", "Bustamante", "Romero", "c29692@utp.edu.pe", LocalDate.of(1980, 8, 8));
        this.p2 = new Persona("40597167", "Miguel", "Bustamante", "Romero", "c29693@utp.edu.pe", LocalDate.of(1980, 9, 8));
        this.savePersona = new Persona(1, "40597166", "Jose", "Bustamante", "Romero", "c29692@utp.edu.pe", LocalDate.of(1980, 8, 8),0);
        this.personas = List.of(p1, p2);
        this.serviceMock = new PersonaServiceImpl();
    }

    @Test
    void registrarTest() {
        //1. preparacion
        when(this.repoMock.save(p1)).thenReturn(savePersona);
        //2. ejecucion
        try {
            rsEsperado = this.serviceMock.create(p1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //3. comparacion
        assertNotNull(rsEsperado);
        assertThat(rsEsperado.getId()).isNotNull();
    }

    @Test
    void registrarTest_ReturnException() {
        //1. preparacion
        when(this.repoMock.save(p1)).thenThrow(RuntimeException.class);
        //2. ejecucion
        try {
            rsEsperado = this.serviceMock.create(p1);
            assertThat(rsEsperado.getId()).isNotNull();
        } catch (Exception e) {
            //3. comparacion
            assertThat(e).isInstanceOf(RuntimeException.class);
        }
    }

    @Test
    void actualizar() {
    }

    @Test
    void listarTodos() {
        //1. preparacion
        when(this.repoMock.findAll()).thenReturn(this.personas);
        //2. ejecución
        List<Persona> listaEsperada = List.of();
        try {
            listaEsperada = this.serviceMock.getAll();
        } catch (Exception e) {
            assertThat(e).isInstanceOf(RuntimeException.class);
        }
        //3. comparacion
        // Verifica que la lista tenga MÁS de 1 elemento
        assertThat(listaEsperada.size()).isGreaterThan(1);
    }

    @Test
    void listarPorFeNacimiento() {
    }

    @Test
    void buscarPorId() {
        //1. preparacion
        when(this.repoMock.findById(anyInt())).thenReturn(Optional.of(savePersona));
        //2. ejecución
        Optional<Persona> personaWithId = null;
        try {
            personaWithId = this.serviceMock.getById(1);
        } catch (Exception e) {
            assertThat(e).isInstanceOf(RuntimeException.class);
        }
        //3. comparacion
        assertThat(personaWithId.get().getId()).isNotNull();
    }

    @Test
    void buscarPorId_ReturnNoEncontrado() {
        //1. preparacion
        when(this.repoMock.findById(anyInt())).thenReturn(Optional.empty());
        //2. ejecución
        Optional<Persona> personaWithId = null;
        try {
            personaWithId = this.serviceMock.getById(1);
        } catch (Exception e) {
            assertThat(e).isInstanceOf(RuntimeException.class);
        }
        //3. comparacion
        assertThat(personaWithId.get().getId()).isNull();
    }

    @Test
    void buscarPorDNI() {
        //1. preparacion
        when(this.repoMock.findByDni(anyString())).thenReturn(Optional.of(savePersona));
        //2. ejecución
        Optional<Persona> personaWithDni = null;
        try {
            personaWithDni = this.serviceMock.getByDni("40597166");
        } catch (Exception e) {
            assertThat(e).isInstanceOf(RuntimeException.class);
        }
        //3. comparacion
        assertThat(personaWithDni.get().getId()).isNotNull();
    }

    @Test
    void eliminar() {
    }
}