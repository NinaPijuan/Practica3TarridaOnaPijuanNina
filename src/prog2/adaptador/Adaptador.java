package prog2.adaptador;

import prog2.model.Dades;
import prog2.model.Exemplar;
import prog2.vista.BiblioException;

public class Adaptador {
    private Dades dades;

    // VISUALITZAR : FER MÈTODES QUE CONVERTEIXEN LES LLISTES D'OBJECTES EN UNA LLISTA D'STRINGS

    /**
     * Crea i afegeix un exemplar a la llista d'exemplars
     * @param id
     * @param titol
     * @param autor
     * @param admetPrestecLlarg
     * @throws BiblioException
     */
    public void afegirExemplar(String id, String titol, String autor, boolean admetPrestecLlarg) throws BiblioException {
        dades.afegirExemplar(id, titol, autor, admetPrestecLlarg);
    }

    // VISUALITZAR EXEMPLARS:
    public void visualitzarExemplars(){



    }

    // AFEGIR USUARIS
    // VISUALITZAR USUARIS

    // AFEGIR PRESTEC
    // RETORNAR PRESTECS
    // VISUALITZAR PRESTECS (TOTS)
    // VISUALITZAR PRESTECS NO RETORNATS

    public void guardaDades(String camiDesti) throws BiblioException {

    }
    public void carregaDades(String camiOrigen) throws BiblioException {

    }
}
