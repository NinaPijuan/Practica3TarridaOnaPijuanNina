package prog2.model;

import java.io.Serializable;

public class Professor extends Usuari implements Serializable {

    public Professor(String email, String nom, String adreca) {
        super(email, nom, adreca, 2, 2);
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
    public String tipusUsuari(){ return "Professor"; }

}
