package Estados;

import System.Pessoa;

public class Habilitada1Dose extends Estado{

    public Habilitada1Dose() {

    }

    @Override
    public void vacinar(Pessoa pessoa) {
      pessoa.setEstado(new Tomou1Dose());
    }

    @Override
    public void updateEstado(Pessoa pessoa) {
    }

    @Override
    public String toString() {
        return "Pessoa Habilatada para tomar a primeira dose da vacinação";
    }
}
