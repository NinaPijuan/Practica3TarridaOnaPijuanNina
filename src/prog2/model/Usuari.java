package prog2.model;

import java.io.Serializable;

public abstract class Usuari implements InUsuari, Serializable {
    private String email;
    private String nom;
    private String adreca;
    private int numPrestecsNormals;
    private int numPrestecstLlargs;
    private int maxPrestecsNormals;
    private int maxPrestecsLlargs;

    public Usuari(String email, String nom, String adreca, int maxPrestecsNormals, int maxPrestecstLlargs) {
        this.email = email;
        this.nom = nom;
        this.adreca = adreca;
        this.maxPrestecsNormals = maxPrestecsNormals;
        this.maxPrestecsLlargs = maxPrestecstLlargs;
        this.numPrestecstLlargs = 0; // 0 per def kuan creem usuari
        this.numPrestecsNormals = 0; // 0 per def kuan creem usuari
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

    /**
     * Mètode abstracte que definim en les subclasses
     */
    @Override
    public abstract String tipusUsuari();

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
    public int getNumPrestecsLlargs() { return numPrestecstLlargs; }

    @Override
    public int getMaxPrestecsNormals() { return numPrestecsNormals; }

    @Override
    public int getMaxPrestecsLlargs() {
        return numPrestecstLlargs;
    }

    @Override
    public String toString(){
        return "Tipus=" + tipusUsuari() + ", Email=" + email + ", Nom=" + nom + ", Adreça="
                + adreca + ", Num. préstecs normals=" + numPrestecsNormals + ", Num. préstecs llargs="
                + numPrestecstLlargs;
    }

}
