package prog2.model;

import prog2.model.Exemplar;
import prog2.model.Prestec;
import prog2.model.Usuari;

import java.io.Serializable;
import java.util.Date;

public class PrestecLlarg extends Prestec implements Serializable {
    public PrestecLlarg(Exemplar exemplar, Usuari usuari, Date dataCreacio, Date dataLimitRetorn, boolean retornat) {
        super(exemplar, usuari, retornat, 140);
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
