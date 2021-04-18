package Estados;

import System.Pessoa;


public abstract class Estado {

    public Estado () {

    }

    public abstract void vacinar(Pessoa pessoa);

    public abstract void updateEstado(Pessoa pessoa);

    public abstract String toString();
}
