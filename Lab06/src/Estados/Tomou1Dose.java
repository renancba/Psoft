package Estados;

import System.Pessoa;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Tomou1Dose extends Estado{


    public Tomou1Dose() {

    }

    @Override
    public void vacinar(Pessoa pessoa) {
        pessoa.setDataPrimeiraDose(LocalDateTime.now());
        updateEstado(pessoa);
    }

    @Override
    public void updateEstado(Pessoa pessoa) {
        LocalDateTime dataAtual = LocalDateTime.now();
        long diasDaPrimeiraDose = ChronoUnit.DAYS.between(pessoa.getDataPrimeiraDose(), dataAtual);
        if (diasDaPrimeiraDose>20) pessoa.setEstado(new Habilitada2Dose());
    }

    @Override
    public String toString() {
        return "Pessoa tomou a primeira dose da vacinação";
    }
}
