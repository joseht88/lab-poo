package pe.edu.utp.poo.util.collection;

import pe.edu.utp.poo.model.Persona;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonaBDMap implements IPersonaBaseDatos {

    private final Map<Integer, Persona> baseDatos;
    private static int contador = 0;

    public PersonaBDMap() {
        this.baseDatos = new HashMap<>();
        contador++;
    }

    @Override
    public Persona save(Persona p) {
        p.setId(contador);
        return this.baseDatos.put(contador, p);
    }

    @Override
    public Persona update(Persona p) {
        return this.baseDatos.replace(p.getId(), p);
    }

    @Override
    public Persona getId(Integer id) {
        return this.baseDatos.get(id);
    }

    @Override
    public List<Persona> getAll() {
        return List.of();
    }

    @Override
    public void delete(Integer id) {
        Persona eliminar = getId(id);
        this.baseDatos.remove(eliminar);
    }

    @Override
    public boolean deleteIterator(Integer id) {
        return true;
    }
}
