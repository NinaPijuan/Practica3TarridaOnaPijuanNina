package prog2.model;

import prog2.vista.BiblioException;

import java.io.Serializable;
import java.util.Iterator;

public class LlistaExemplars extends Llista<Exemplar> implements Serializable {

    public LlistaExemplars() {
        super();
    }

    /**
     * Mètode que afegeix un exemplar a la llista (reescrit perquè s'afegeix amb condicions)
     * @param exemplar
     * @throws BiblioException quan ja existeix l'exemplar (es mira amb l'id)
     */
    @Override
    public void afegir(Exemplar exemplar) throws BiblioException {

        String idNou = exemplar.getId();
        Iterator<Exemplar> it = llista.iterator();

        while (it.hasNext()) {
            Exemplar exe = it.next();
            if (exe.getId().equals(idNou)) {
                throw new BiblioException("Aquest exemplar ja existeix");
            }
        }

        llista.add(exemplar);
    }

    public boolean contains(String id) {
        Iterator<Exemplar> it = llista.iterator();
        Exemplar exemplarAux;
        while (it.hasNext()) {
            exemplarAux = it.next();
            if (exemplarAux.getId().equals(id)) return true;
        }
        return false;
    }

    public void esborrar(Exemplar exemplar) throws BiblioException {
        Iterator<Exemplar> it = llista.iterator();
        Exemplar exemplarAux;
        boolean trobat = false;
        while (it.hasNext() && !trobat) {
            exemplarAux = it.next();
            if (exemplarAux.getId().equals(exemplar.getId())) {
                it.remove();
                trobat = true;
            }
        }
        if (!trobat) throw new BiblioException("No existeix");
    }
}
