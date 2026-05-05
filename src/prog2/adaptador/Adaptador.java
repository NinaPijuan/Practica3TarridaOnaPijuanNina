package prog2.adaptador;

import prog2.model.Dades;
import prog2.model.Exemplar;
import prog2.model.Prestec;
import prog2.model.Usuari;
import prog2.vista.BiblioException;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Adaptador implements Serializable {
    private Dades dades;

    public Adaptador() {
        this.dades = new Dades();
    }

    /**
     * Retorna llista amb tots els exemplars
     */
    public List<String> recuperarExemplars() {
        ArrayList<Exemplar> exemplars = dades.recuperaExemplars();
        ArrayList<String> llista = new ArrayList<>();
        Iterator<Exemplar> it = exemplars.iterator();
        while(it.hasNext()) {
            llista.add(it.next().toString());
        }
        return llista;
    }

    /** Retorna llista amb tots els usuaris
     */
    public List<String> recuperarUsuaris() {
        ArrayList<Usuari> usuaris = dades.recuperaUsuaris();
        ArrayList<String> llista = new ArrayList<>();
        Iterator<Usuari> it = usuaris.iterator();
        while(it.hasNext()) {
            llista.add(it.next().toString());
        }
        return llista;
    }

    /** Retorna llista amb tots els préstecs (retornats i no retornats).
     */
    public List<String> recuperarPrestecs() {
        ArrayList<Prestec> prestecs = dades.recuperaPrestecs();
        ArrayList<String> llista = new ArrayList<>();
        Iterator<Prestec> it = prestecs.iterator();
        while(it.hasNext()) {
            llista.add(it.next().toString());
        }
        return llista;
    }

    /**
     * Retorna llista amb els préstecs que encara no han estat retornats.
     */
    public List<String> recuperarPrestecsNoRetornats() {
        ArrayList<Prestec> prestecsNR = dades.recuperaPrestecsNoRetornats();
        ArrayList<String> llista = new ArrayList<>();
        Iterator<Prestec> it = prestecsNR.iterator();
        while(it.hasNext()) {
            llista.add(it.next().toString());
        }
        return llista;
    }


    // EXEMPLARS

    /**
     * Crea i afegeix un exemplar a la llista d'exemplars.rec
     */
    public void afegirExemplar(String id, String titol, String autor, boolean admetPrestecLlarg) throws BiblioException {
        dades.afegirExemplar(id, titol, autor, admetPrestecLlarg);
    }

    /**
     * Retorna el nombre d'exemplars registrats
     */
    public int getNumExemplars() {
        return dades.recuperaExemplars().size();
    }

    // USUARIS

    /**
     * Crea i afegeix un usuari a la llista d'usuaris.
     */
    public void afegirUsuari(String email, String nom, String adreca, boolean esEstudiant) throws BiblioException {
        dades.afegirUsuari(email, nom, adreca, esEstudiant);
    }


    /** Retorna el nombre d'usuaris registrats.
     */
    public int getNumUsuaris() {
        return dades.recuperaUsuaris().size();
    }

    // PRÉSTECS

    /**
     * Crea un préstec per a un exemplar i un usuari donats pels seus índexs.
     */
    public void afegirPrestec(int exemplarPos, int usuariPos, boolean esLlarg) throws BiblioException {
        dades.afegirPrestec(exemplarPos, usuariPos, esLlarg);
    }

    /**
     * Marca un préstec com a retornat.
     */
    public void retornarPrestec(int position) throws BiblioException {
        dades.retornarPrestec(position);
    }

    /** Retorna el nombre total de préstecs registrats.
     */
    public int getNumPrestecs() {
        return dades.recuperaPrestecs().size();
    }

    public void guardaDades(String camiDesti) throws BiblioException {
        // Creem el fitxer
        File fitxer = new File(camiDesti);

        try {

            // Creem el canal i la maleta
            FileOutputStream fos = new FileOutputStream(fitxer);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            // Escrivim el Camping (this)
            oos.writeObject(this);

            // Tanquem canals
            fos.close();
            oos.close();

        } catch (IOException e) {
            throw new BiblioException("No s'ha pogut guardar al fitxer: " + e.getMessage());
        }
    }

    public void carregaDades(String camiOrigen) throws BiblioException {
        // Inicialitzem les variables per poder veure-les dins del try
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        // Provem de donar-los valors; si no -> llancem excepcions
        try {
            fis = new FileInputStream(camiOrigen);
            ois = new ObjectInputStream(fis);
            Adaptador adaptadorAux = (Adaptador) ois.readObject();
            this.dades = adaptadorAux.dades;

        } catch (FileNotFoundException e) {
            throw new BiblioException("El fitxer no existeix");
        } catch (ClassNotFoundException e) {
            throw new BiblioException("No s'han pogut llegir les dades del fitxer");
        } catch (IOException e) {
            throw new BiblioException("Error llegint el fitxer: " + e.getMessage());
        }

        // Provem de tancar els canals
        finally {
            try {
                fis.close();
                ois.close();
            } catch (NullPointerException e) {
                throw new BiblioException("El fitxer no existeix");
            } catch (IOException e) {
                throw new BiblioException("No s'ha pogut tancar el fitxer");
            }
        }
    }
}
