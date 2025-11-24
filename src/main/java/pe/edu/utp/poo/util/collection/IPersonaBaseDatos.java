package pe.edu.utp.poo.util.collection;

import pe.edu.utp.poo.model.Persona;

import java.util.List;

public interface IPersonaBaseDatos {

    Persona save(Persona p);

    Persona update(Persona p);

    Persona getId(Integer id);

    List<Persona> getAll();

    void delete(Integer id);

    boolean deleteIterator(Integer id);
}
