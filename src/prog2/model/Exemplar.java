package prog2.model;

import java.io.Serializable;

// Setters, getters i toString
public class Exemplar implements InExemplar, Serializable {
    private String id;
    private String titol;
    private String autor;
    private boolean admetPrestecLlarg;
    private boolean disponible;

    public Exemplar(String id, String titol, String autor, boolean admetPrestecLlarg, boolean disponible) {
        // Acabar
    }
    @Override
    public void setId(String id) {

    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public void setTitol(String titol) {

    }

    @Override
    public String getTitol() {
        return null;
    }

    @Override
    public void setAutor(String autor) {

    }

    @Override
    public String getAutor() {
        return null;
    }

    @Override
    public void setAdmetPrestecLlarg(boolean admetPrestecLlarg) {

    }

    @Override
    public boolean getAdmetPrestecLlarg() {
        return false;
    }
}
