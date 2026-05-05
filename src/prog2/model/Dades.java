package prog2.model;

import prog2.vista.BiblioException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class Dades implements InDades, Serializable {

    private LlistaUsuaris llistaUsuaris;
    private LlistaExemplars llistaExemplars;
    private LlistaPrestecs llistaPrestecs;

    public Dades() {
        this.llistaUsuaris = new LlistaUsuaris();
        this.llistaExemplars = new LlistaExemplars();
        this.llistaPrestecs = new LlistaPrestecs();
    }

    /**
     * Afegeix exemplar. Llança excepció si l'id ja existeix
     *
     * @param id
     * @param titol
     * @param autor
     * @param admetPrestecLlarg
     */
    @Override
    public void afegirExemplar(String id, String titol, String autor, boolean admetPrestecLlarg) throws BiblioException {
        // Creem un exemplar nou i el mètode afegir de LlistaExemplars gestiona la resta
        Exemplar exemplar = new Exemplar(id, titol, autor, admetPrestecLlarg);
        llistaExemplars.afegir(exemplar);

    }

    @Override
    public ArrayList<Exemplar> recuperaExemplars() {
        return llistaExemplars.getArrayList();
    }

    /**
     * Afegeix usuari. Llança excepció si l'email ja existeix
     *
     * @param email
     * @param nom
     * @param adreca
     * @param esEstudiant
     */
    @Override
    public void afegirUsuari(String email, String nom, String adreca, boolean esEstudiant) throws BiblioException {

        // Creem un usuari nou (de tipus concret) i el mètode afegir de la LlistaUsuaris fa la resta
        if(esEstudiant){
            Estudiant estudiant = new Estudiant(email, nom, adreca);
            llistaUsuaris.afegir(estudiant);
        }
        else{
            Professor professor = new Professor(email, nom, adreca);
            llistaUsuaris.afegir(professor);
        }

    }

    @Override
    public ArrayList<Usuari> recuperaUsuaris() {
        return llistaUsuaris.getArrayList();
    }

    /**
     * Afegeix préstec. Ha de fer diferents comprovacions que poden llançar excepcions.
     * Quan s'afegeix el préstec, s'han de tenir en compte les posicions d'exemplar
     * i usuari dins dels seus ArrayLists
     *
     * @param exemplarPos
     * @param usuariPos
     * @param esLlarg
     */
    @Override
    public void afegirPrestec(int exemplarPos, int usuariPos, boolean esLlarg) throws BiblioException {
        // Llista té un mètode (getAt()) kue retorna l'objecte en la posició donada
        // El getAt() no tira cap throw a InLlista així k entenc k donem per suposat k tot existeix i sempre es troba


        // Buskuem exemplar i mirem si està disponible
        Exemplar exemplar = llistaExemplars.getAt(exemplarPos);
        if(!exemplar.isDisponible()){ throw new BiblioException("Exemplar no disponible"); }

        // En cas kue es vulgui fer un préstec llarg, mirem si l'exemplar ho admet
        if(esLlarg) {
            if (!exemplar.getAdmetPrestecLlarg()) {
                throw new BiblioException("L'exemplar no admet un préstec llarg");
            }
        }

        // Buskuem l'usuari i li agafem el email
        Usuari usuari = llistaUsuaris.getAt(usuariPos);
        String emailUsuari = usuari.getEmail();

        // Buskuem dins de llistaPrestecs l'usuari, i si el trobem mirem si el préstec està endarrerit
        Iterator<Prestec> it = llistaPrestecs.getArrayList().iterator();
        while( it.hasNext() ){
                Prestec pres = it.next();
                if( pres.getUsuari().getEmail().equals(emailUsuari) ) {
                    if (pres.prestecEndarrerit()) {
                        throw new BiblioException("L'usuari té préstecs endarrerits");
                    }
                }
        }


        // Mirem si l'usuari no supera el número de préstecs màxims
        // Creem préstec i l'afegim
        if(esLlarg){
            if (usuari.getNumPrestecsLlargs() == usuari.getMaxPrestecsLlargs()){ throw new BiblioException("L'usuari supera el número màxim de préstecs llargs"); }
            PrestecLlarg prestec = new PrestecLlarg(exemplar, usuari, new Date());
            llistaPrestecs.afegir(prestec);
            usuari.setNumPrestecsLlargs(usuari.getNumPrestecsLlargs() + 1);
        }
        else{
            if (usuari.getNumPrestecsNormals() == usuari.getMaxPrestecsNormals()) { throw new BiblioException("L'usuari supera el número màxim de préstecs normals"); }
            PrestecNormal prestec = new PrestecNormal(exemplar, usuari, new Date());
            llistaPrestecs.afegir(prestec);
            usuari.setNumPrestecsNormals(usuari.getNumPrestecsNormals() + 1);
        }
        exemplar.setDisponible(false);

    }

    /**
     * Retornar préstec. Llança excepció si el prestec ja es vaig retornar.
     * El préstec s'identifica amb la seva posició dins de l'ArrayList
     *
     * @param position
     */
    @Override
    public void retornarPrestec(int position) throws BiblioException {

        // Llista té un mètode (getAt()) kue retorna l'objecte en la posició donada
        Prestec prestec = llistaPrestecs.getAt(position);

        // Llancem excepció si l'exemplar ja ha estat retornat
        if (prestec.getRetornat()){ throw new BiblioException("L'exemplar ja ha estat retornat"); }

        // Si no, el retornem amb el mètode de préstec
        prestec.retorna();

    }

    /**
     * @return array de tots els préstecs
     */
    @Override
    public ArrayList<Prestec> recuperaPrestecs() {
        return llistaPrestecs.getArrayList();
    }


    /**
     * Fa un recorregut per la llista de préstecs buscant els no retornats i els guarda en una llista
     * @return array de préstecs no retornats
     */
    @Override
    public ArrayList<Prestec> recuperaPrestecsNoRetornats() {

        ArrayList<Prestec> noRetornats = new ArrayList<>();
        Iterator<Prestec> it = llistaPrestecs.getArrayList().iterator();
        while( it.hasNext() ){
            Prestec pres = it.next();
            if( !pres.getRetornat() ) {
                noRetornats.add(pres);
            }
        }

        return noRetornats;
    }


}
