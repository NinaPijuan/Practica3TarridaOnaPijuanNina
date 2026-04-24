package prog2.model;

import java.io.Serializable;

public class Exemplar implements InExemplar, Serializable {
    private String id;
    private String titol;
    private String autor;
    private boolean admetPrestecLlarg;
    private boolean disponible;

    public Exemplar(String id, String titol, String autor, boolean admetPrestecLlarg) {
        this.id = id;
        this.titol = titol;
        this.autor = autor;
        this.admetPrestecLlarg = admetPrestecLlarg;
        this.disponible = true; // Kuan creem un exemplar, està disponible per definició
    }


    @Override
    public void setId(String id) { this.id = id; }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setTitol(String titol) { this.titol = titol; }

    @Override
    public String getTitol() {
        return titol;
    }

    @Override
    public void setAutor(String autor) { this.autor = autor; }

    @Override
    public String getAutor() {
        return autor;
    }

    @Override
    public void setAdmetPrestecLlarg(boolean admetPrestecLlarg) { this.admetPrestecLlarg = admetPrestecLlarg; }

    @Override
    public boolean getAdmetPrestecLlarg() {
        return admetPrestecLlarg;
    }

    // No tenen l'Override perkuè no existeixen en InExemplar
    public void setDisponible(boolean disponible){ this.disponible = disponible; }

    public boolean isDisponible(){ return disponible; }

    @Override
    public String toString(){
        return "Id=" + id + ", Títol=" + titol + ", Autor=" + autor + ", Admet Préstec Llarg="
                + admetPrestecLlarg +", Disponible=" + disponible;
    }

}
