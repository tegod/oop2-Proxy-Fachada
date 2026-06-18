package ej1;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;


public class TelefonoProxy extends AbstractSet<Telefono> {
    private int idPersona;
    private Set<Telefono> telefonos;
    private PersonaDao personaDao;

    public TelefonoProxy(int idPersona, PersonaDao personaDao) {
        this.idPersona = idPersona;
        this.personaDao = personaDao;
    }

    public void cargar() {
        if (telefonos == null) {
            telefonos = personaDao.buscarTelefonoPorPersonaId(idPersona);
        }
    }

    @Override
    public int size() {
        cargar();
        return this.telefonos.size();
    }

    @Override
    public boolean isEmpty() {
        return this.telefonos.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<Telefono> iterator() {
        cargar();
        return telefonos.iterator();
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }
}
