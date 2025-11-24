package pe.edu.utp.poo.util.collection;

import pe.edu.utp.poo.model.Persona;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PersonaBDSet implements IPersonaBaseDatos {

    private final Set<Persona> baseDatos;
    private static int contador = 0;

    public PersonaBDSet() {
        contador++;
        this.baseDatos = new HashSet<>();
    }

    @Override
    public Persona save(Persona p) {
        p.setId(contador);
        var res = this.baseDatos.add(p);
        return res ? p : null;
    }

    @Override
    public Persona update(Persona p) {
        var persona = getId(p.getId());
        this.baseDatos.remove(persona);
        var res = this.baseDatos.add(p);
        return res ? p : null;
    }

    @Override
    public Persona getId(Integer id) {
        Persona p = null;
        for (Persona obj : this.baseDatos) {
            if (id.equals(obj.getId())) {
                p = obj;
                break;
            }
        }
        return p;
    }

    @Override
    public List<Persona> getAll() {
        return this.baseDatos.stream().toList();
    }

    @Override
    public void delete(Integer id) {
        var persona = getId(id);
        this.baseDatos.remove(persona);
    }

    @Override
    public boolean deleteIterator(Integer id) {
       return true;
    }
}
