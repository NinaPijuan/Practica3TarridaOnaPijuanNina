package prog2.model;

import prog2.vista.BiblioException;

import java.io.Serializable;
import java.util.Iterator;

// NO TÉ ATRIBUTS NI CONSTRUCTORS PK JA ESTAN A LLISTA
public class LlistaUsuaris extends Llista<Usuari> implements Serializable {


    /**
     * Mètode que afegeix un usuari a la llista (reescrit perquè s'afegeix amb condicions)
     * @param usuari
     * @throws BiblioException quan ja existeix l'usuari (es mira amb l'email)
     */
    @Override
    public void afegir(Usuari usuari) throws BiblioException{

        String emailNou = usuari.getEmail();
        Iterator<Usuari> it = llista.iterator();

        while(it.hasNext()){
            Usuari usu = it.next();
            if( usu.getEmail().equals(emailNou) ){ throw new BiblioException("Aquest usuari ja existeix"); }
        }

        llista.add(usuari);
    }

    // ITERADORS
}
