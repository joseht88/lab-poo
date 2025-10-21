package pe.edu.utp.poo.collection;

import pe.edu.utp.poo.modelo.Persona;

import java.util.ArrayList;
import java.util.List;

public class PersonaBDList implements IPersonaBaseDatos {

    private final List<Persona> baseDatos;
    private static int contador = 0;

    public PersonaBDList() {
        contador++;
        this.baseDatos = new ArrayList<>();
    }

    @Override
    public Persona save(Persona p) {
        p.setId(contador);
        this.baseDatos.add(p);
        return p;
    }

    @Override
    public Persona update(Persona p) {
        if (p.getId() == null) return null;
        Persona persona = getId(p.getId());
        int idx = this.baseDatos.indexOf(persona);
        this.baseDatos.set(idx, p);
        return p;
    }

    @Override
    public Persona getId(Integer id) {
        Persona p = null;
        for(Persona obj: this.baseDatos){
            if(id.equals(obj.getId())){
                p = obj;
                break;
            }
        }
        return p;
    }

    @Override
    public List<Persona> getAll() {
        return this.baseDatos;
    }

    @Override
    public void delete(Integer id) {
        Persona p = getId(id);
        this.baseDatos.remove(p);
    }
}
