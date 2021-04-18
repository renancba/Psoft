package Estados;

import System.Pessoa;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;

public class NaoHabilitada extends Estado {

    private long idadeMinima;

    private List<String> comorbidadesPrioridade = Arrays.asList("oncológico", "transplantado", "hipertensão", "pneumopatias crônicas graves", "diabetes mellitus", "problemas de coração", "doença cerebrovascular", "doença renal crônica", "anemia falciforme", "obesidade mórbida", "síndrome de down", "HIV", "cirrose hepática");

    private List<String> profissoesPrioridade = Arrays.asList("médico", "professor", "dentista", "enfermeiro", "militar", "farmacêuticos", "policial", "serviços gerais em hospitais", "auxiliares de enfermagem");

    public NaoHabilitada() {
        this.idadeMinima = -1;
    }

    @Override
    public void vacinar(Pessoa pessoa) {
        updateEstado(pessoa);
    }

    @Override
    public void updateEstado(Pessoa pessoa) {
        if (verificaIdade(pessoa) | verificaComorbidade(pessoa) | verificaProfissão(pessoa)) pessoa.setEstado(new Habilitada1Dose());
    }

    @Override
    public String toString() {
        return "Pessoa Não Habilatada para vacinação";
    }

    public void setIdadeMinima(int idadeMinima){
        this.idadeMinima = idadeMinima;
    }

    private boolean verificaIdade(Pessoa pessoa){
        if (this.idadeMinima == -1) return false;
        LocalDateTime atual = LocalDateTime.now();
        long anos = pessoa.getDataNascimento().until(atual, ChronoUnit.YEARS);
        if (anos >= idadeMinima) return true;
        return false;
    }

    private boolean verificaProfissão(Pessoa pessoa){
        if (pessoa.getProfissão() == null) return false;
        if (profissoesPrioridade.contains(pessoa.getProfissão())) return true;
        return false;
    }

    private boolean verificaComorbidade(Pessoa pessoa){
        if (pessoa.getComorbidades() == null) return false;
        if (pessoa.getComorbidades().size() == 0) return false;
        for (String comorbidade:pessoa.getComorbidades()) {
            if (comorbidadesPrioridade.contains(comorbidade)) return true;
        }
        return false;
    }





}
