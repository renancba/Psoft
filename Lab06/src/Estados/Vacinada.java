package Estados;

import System.Pessoa;

public class Vacinada extends Estado{

    @Override
    public void vacinar(Pessoa pessoa) {
        pessoa.setEstado(new Vacinada());
    }

    @Override
    public void updateEstado(Pessoa pessoa) {
    }

    @Override
    public String toString() {
        return "Pessoa VACINADA! EBAAA ;) #SUS";
    }
}
