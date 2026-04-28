package prog2.model;

import prog2.vista.BiblioException;

import java.io.Serializable;
import java.util.Date;

public abstract class Prestec implements InPrestec, Serializable {
    private Exemplar exemplar;
    private Usuari usuari;
    private long durada; // Mil·lisegons
    private Date dataCreacio;
    private Date dataLimitRetorn;
    private boolean retornat;

    public Prestec(Exemplar exemplar, Usuari usuari, long durada, Date dataCreacio) {
        this.exemplar = exemplar;
        this.usuari = usuari;
        this.durada = durada * 1000;
        this.dataCreacio = dataCreacio;
        this.dataLimitRetorn = new Date();
        this.dataLimitRetorn.setTime(dataCreacio.getTime() + durada * 1000);
        retornat = false; // Kuan creem un préstec, retorn = false per definició
    }
    @Override
    public void setExemplar(Exemplar exemplar) { this.exemplar = exemplar; }

    @Override
    public Exemplar getExemplar() { return exemplar; }

    @Override
    public void setUsuari(Usuari usuari) { this.usuari = usuari; }

    @Override
    public Usuari getUsuari() { return usuari; }

    @Override
    public void setDataCreacio(Date data) { this.dataCreacio = data; }

    @Override
    public Date getDataCreacio() { return dataCreacio; }

    @Override
    public void setDataLimitRetorn(Date data) { this.dataLimitRetorn = data; }

    @Override
    public Date getDataLimitRetorn() { return dataLimitRetorn; }

    /**
     * Mètode que definim en cada subclasse
     */
    @Override
    public abstract String tipusPrestec();

    @Override
    public void setRetornat(boolean retornat) { this.retornat = retornat; }

    @Override
    public boolean getRetornat() { return retornat; }

    /**
     * Retornar prestec. Llança excepció si el prestec ja es vaig retornar
     */
    @Override
    public void retorna() {

        // if(exemplar.isDisponible()){ throw new BiblioException("L'exemplar ja ha estat retornat"); }

        // Si encara no ha estat retornat:
        exemplar.setDisponible(true);
        retornat = true;
        if (this instanceof PrestecLlarg) usuari.setNumPrestecsLlargs(usuari.getNumPrestecsLlargs() - 1);
        else usuari.setNumPrestecsNormals(usuari.getNumPrestecsNormals() - 1);

    }

    /**
     * Retorna la durada del préstec
     */
    @Override
    public long duradaPrestec(){ return durada; }

    /**
     * Retornar true si el prestec està endarrerit per a la data actual
     */
    @Override
    public boolean prestecEndarrerit() {

        boolean endarrerit = false;
        if(!retornat){

            Date avui = new Date(); // Crea date amb data actual
            // Mirem si la data de retorn ja ha passat
            if (dataLimitRetorn.before(avui)){ endarrerit = true; }
        }

        return endarrerit;

    }


    @Override
    public String toString(){
        return "Tipus=" + tipusPrestec() + ", Exemplar=" + exemplar.getTitol() + ", Usuari=" + usuari.getNom()+ ", Data de creació="
                + dataCreacio + ", Data límit de retorn=" + dataLimitRetorn + ", Retornat="
                + retornat;
    }
}
