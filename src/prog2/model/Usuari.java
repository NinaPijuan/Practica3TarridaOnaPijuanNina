package prog2.model;

import java.io.Serializable;

// Setters, getters i toString
public abstract class Usuari implements InUsuari, Serializable {
    private String email;
    private String nom;
    private String adreca;
    private int numPrestecsNormals;
    private int numPrestecstLlargs;

    public Usuari(String email, String nom, String adreca, int numPrestecsNormals, int numPrestecstLlargs) {
        this.email = email;
        this.nom = nom;
        this.adreca = adreca;
        this.numPrestecsNormals = numPrestecsNormals;
        this.numPrestecstLlargs = numPrestecstLlargs;
    }
    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public void setAdreca(String adreca) {
        this.adreca = adreca;
    }

    @Override
    public String getAdreca() {
        return adreca;
    }

    @Override
    public String tipusUsuari() {
        return null;
    }

    @Override
    public void setNumPrestecsNormals(int numPrestecsNormals) {
        this.numPrestecsNormals = numPrestecsNormals;
    }

    @Override
    public int getNumPrestecsNormals() {
        return numPrestecsNormals;
    }

    @Override
    public void setNumPrestecsLlargs(int numPrestecstLlargs) {
        this.numPrestecstLlargs = numPrestecstLlargs;
    }

    @Override
    public int getNumPrestecsLlargs() {
        return numPrestecstLlargs;
    }

    @Override
    public int getMaxPrestecsNormals() {
        return 0;
    }

    @Override
    public int getMaxPrestecsLlargs() {
        return 0;
    }
}
