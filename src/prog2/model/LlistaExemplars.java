package prog2.model;

import prog2.vista.BiblioException;

import java.io.Serializable;
import java.util.Iterator;

// NO TÉ ATRIBUTS NI CONSTRUCTORS PK JA ESTAN A LLISTA
public class LlistaExemplars extends Llista<Exemplar> implements Serializable {


    /**
     * Mètode que afegeix un exemplar a la llista (reescrit perquè s'afegeix amb condicions)
     * @param exemplar
     * @throws BiblioException quan ja existeix l'exemplar (es mira amb l'id)
     */
    @Override
    public void afegir(Exemplar exemplar) throws BiblioException{

        String idNou = exemplar.getId();
        Iterator<Exemplar> it = llista.iterator();

        while(it.hasNext()){
            Exemplar exe = it.next();
            if( exe.getId().equals(idNou) ){ throw new BiblioException("Aquest exemplar ja existeix"); }
        }

        llista.add(exemplar);
    }


    // ITERADORS
}
