package pe.edu.utp.poo.collection;

import pe.edu.utp.poo.modelo.Persona;

import java.util.List;

public interface IPersonaBaseDatos {

    public Persona save(Persona p);

    public Persona update(Persona p);

    public Persona getId(Integer id);

    public List<Persona> getAll();

    public void delete(Integer id);
}
