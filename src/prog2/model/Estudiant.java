package prog2.model;

import java.io.Serializable;

public class Estudiant extends Usuari implements Serializable {
    public Estudiant(String email, String nom, String adreca) {
        super(email, nom, adreca, 2, 1);
    }

    @Override
    public int getMaxPrestecsNormals() {
        return super.getMaxPrestecsNormals();
    }

    @Override
    public int getMaxPrestecsLlargs() {
        return super.getMaxPrestecsLlargs();
    }

    @Override
    public String tipusUsuari(){ return "Estudiant"; }
}
