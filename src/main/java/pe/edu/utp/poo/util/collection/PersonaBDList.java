package pe.edu.utp.poo.util.collection;

import pe.edu.utp.poo.model.Persona;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PersonaBDList implements IPersonaBaseDatos {

    private final List<Persona> baseDatos;
    private static int contador = 1;

    public PersonaBDList() {
        this.baseDatos = new ArrayList<>();
    }

    @Override
    public Persona save(Persona p) {
        p.setId(contador++);
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
        if(p != null)
            this.baseDatos.remove(p);
    }

    @Override
    public boolean deleteIterator(Integer id){
        Iterator<Persona> it = this.baseDatos.iterator();
        boolean result = false;
        while (it.hasNext()){
            Persona p = it.next();
            if(p.getId().equals(id)) {
                it.remove();
                result = true;
                break;
            }
        }
        return result;
    }

}
