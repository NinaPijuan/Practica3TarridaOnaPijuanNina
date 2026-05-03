package prog2.model;

import java.io.Serializable;
import java.util.Date;

public class PrestecLlarg extends Prestec implements Serializable {

    public PrestecLlarg(Exemplar exemplar, Usuari usuari, Date dataCreacio) {
        super(exemplar, usuari, 140, dataCreacio);
    }

    @Override
    public String tipusPrestec() {
        return "Llarg";
    }

    @Override
    public long duradaPrestec() {
        return super.duradaPrestec();
    }
    // Preguntar mètodes duradaPrestec i tipusPrestec (per què està aquí i no a superclasse??)
}
