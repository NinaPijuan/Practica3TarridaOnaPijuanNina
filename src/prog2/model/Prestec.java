package prog2.model;

import java.io.Serializable;
import java.util.Date;
// toString
public abstract class Prestec implements InPrestec, Serializable {
    private Exemplar exemplar;
    private Usuari usuari;
    private Date dataCreacio;
    private Date dataLimitRetorn;
    private boolean retornat;
    private long durada; // Mil·lisegons

    public Prestec(Exemplar exemplar, Usuari usuari, long durada) {
        this.exemplar = exemplar;
        this.usuari = usuari;
        this.durada = durada;
        // exemplar.setDisponible(false)
        // Posar no disponible l'exemplar
        this.dataCreacio = new Date(); // Crea date amb data actual
        dataLimitRetorn.setTime(dataCreacio.getTime() + durada);

        retornat = false;
    }
    @Override
    public void setExemplar(Exemplar exemplar) {

    }

    @Override
    public Exemplar getExemplar() {
        return null;
    }

    @Override
    public void setUsuari(Usuari usuari) {

    }

    @Override
    public Usuari getUsuari() {
        return null;
    }

    @Override
    public void setDataCreacio(Date data) {

    }

    @Override
    public Date getDataCreacio() {
        return null;
    }

    @Override
    public void setDataLimitRetorn(Date data) {

    }

    @Override
    public Date getDataLimitRetorn() {
        return null;
    }

    @Override
    public String tipusPrestec() {
        return null;
    }

    @Override
    public void setRetornat(boolean retornat) {

    }

    @Override
    public boolean getRetornat() {
        return false;
    }

    /**
     * Retornar prestec. Llança excepció si el prestec ja es vaig retornar
     */
    @Override
    public void retorna() {
        // Posar exemplar a disponible
        retornat = true;
    }

    /**
     * Retornar durada prestec. La durada del prestec depen del tipus de prestec
     */
    @Override
    public long duradaPrestec() {
        return 0;
    }

    /**
     * Retornar true si el prestec està endarrerit per a la data actual
     */
    @Override
    public boolean prestecEndarrerit() {
        return false;
    }
}
