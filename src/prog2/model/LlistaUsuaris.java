package prog2.model;

import prog2.vista.BiblioException;

import java.io.Serializable;
import java.util.Iterator;

public class LlistaUsuaris extends Llista<Usuari> implements Serializable {

    public LlistaUsuaris() {
        super();
    }

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

    public boolean contains(String email) {
        Iterator<Usuari> it = llista.iterator();
        Usuari usuariAux;
        while (it.hasNext()) {
            usuariAux = it.next();
            if (usuariAux.getEmail().equals(email)) return true;
        }
        return false;
    }

    public void esborrar(Usuari usuari) throws BiblioException {
        Iterator<Usuari> it = llista.iterator();
        Usuari usuariAux;
        boolean trobat = false;
        while (it.hasNext() && !trobat) {
            usuariAux = it.next();
            if (usuariAux.getEmail().equals(usuari.getEmail())) {
                it.remove();
                trobat = true;
            }
        }
        if (!trobat) throw new BiblioException("No existeix");
    }
}
