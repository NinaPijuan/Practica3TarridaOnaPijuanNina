package prog2.model;

import prog2.vista.BiblioException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class Dades implements InDades, Serializable {
    // No afegir mètodes nous

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
        return null;
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
        return null;
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

        // Buskuem l'usuari i li agafem el nom
        Usuari usuari = llistaUsuaris.getAt(usuariPos);
        String nomUsuari = usuari.getNom();

        // Buskuem dins de llistaPrestecs l'usuari, i si el trobem mirem si el préstec està endarrerit
        Iterator<Prestec> it = llistaPrestecs.getArrayList().iterator();
        while( it.hasNext() ){
                Prestec pres = it.next();
                if( pres.getUsuari().getNom().equals(nomUsuari) ) {
                    if (pres.prestecEndarrerit()) {
                        throw new BiblioException("L'usuari té préstecs endarrerits");
                    }
                }
        }

        // Si arribem fins akuí vol dir kue todo bien
        // Creem préstec i l'afegim
        if(esLlarg){
            PrestecLlarg prestec = new PrestecLlarg(exemplar, usuari, new Date());
            llistaPrestecs.afegir(prestec);
        }
        else{
            PrestecNormal prestec = new PrestecNormal(exemplar, usuari, new Date());
            llistaPrestecs.afegir(prestec);
        }

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

        // El mètode retorna() de préstec ja gestiona la resta
        prestec.retorna();

    }

    @Override
    public ArrayList<Prestec> recuperaPrestecs() {
        return null;
    }

    @Override
    public ArrayList<Prestec> recuperaPrestecsNoRetornats() {
        return null;
    }
}
