package prog2.model;

import java.io.Serializable;
import java.util.Date;

public class PrestecNormal extends Prestec implements Serializable {
    public PrestecNormal(Exemplar exemplar, Usuari usuari, Date dataCreacio, Date dataLimitRetorn, boolean retornat) {
        super(exemplar, usuari, 70);
    }

    @Override
    public String tipusPrestec() {
        return "Normal";
    }

    @Override
    public long duradaPrestec() {
        return super.duradaPrestec();
    }

    // Preguntar mètodes duradaPrestec i tipusPrestec (per què està aquí i no a superclasse??)
}
