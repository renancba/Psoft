package Estados;

import System.Pessoa;

public class Habilitada2Dose extends Estado{

    @Override
    public void vacinar(Pessoa pessoa) {
        pessoa.setEstado(new Vacinada());
    }

    @Override
    public void updateEstado(Pessoa pessoa) {
    }

    @Override
    public String toString() {
        return "Pessoa Habilatada para tomar a segunda dose da vacinação";
    }
}
