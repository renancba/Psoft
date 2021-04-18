package System;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SUSVac {

    private Map<String, Pessoa> pessoas;

    public SUSVac() {
        this.pessoas = new HashMap<String, Pessoa>();
    }

    public void cadastraPessoa(String nome, String CPF, String endereço, int numeroSUS, String email, String telefone,
                               String profissão, List<String> comorbidades, int diaNascimento, int mesNascimento, int anoNascimento) {

        if (CPF == null || CPF.length() != 11 || CPF.trim().isEmpty()) {
            System.out.println("Pessoa não cadastrada. CPF inválido.");
        } else {
            Pessoa pessoa = new Pessoa(nome, CPF, endereço, numeroSUS, email, telefone, profissão, comorbidades, diaNascimento, mesNascimento, anoNascimento);
            this.pessoas.put(CPF, pessoa);
            System.out.println("Pessoa cadastrada com sucesso.");
        }
    }

    public void alterarNomePessoa(String cpf, String nome) {
        if (nome.trim().isEmpty()) {
            System.out.println("Nome inválido.");
        }
        this.pessoas.get(cpf).setNome(nome);
        System.out.println("Nome alterado com sucesso.");
    }

    public void alterarEndereco(String cpf, String endereco) {
        if (endereco.trim().isEmpty()) {
            System.out.println("Endereço inválido.");
        }
        this.pessoas.get(cpf).setEndereço(endereco);
        System.out.println("Endereço alterado com sucesso.");

    }

    public void alterarNumSUS(String cpf, int numSus) {
        if (numSus <= 0) {
            System.out.println("Número do SUS inválido.");
        }
        this.pessoas.get(cpf).setNumeroSUS(numSus);
        System.out.println("Número do SUS alterado com sucesso.");
    }

    public void alterarEmail(String cpf, String email) {
        if (email.trim().isEmpty()) {
            System.out.println("E-mail inválido.");
        }
        this.pessoas.get(cpf).setEmail(email);
        System.out.println("E-mail alterado com sucesso.");
    }

    public void alterarTelefone(String cpf, String telefone) {
        if (telefone.trim().isEmpty()) {
            System.out.println("Telefone inválido.");
        }
        this.pessoas.get(cpf).setTelefone(telefone);
        System.out.println("Telefone alterado com sucesso.");
    }

    public void alterarProfissao(String cpf, String profissao) {
        if (profissao.trim().isEmpty()) {
            System.out.println("Profissão inválida.");
        }
        this.pessoas.get(cpf).setProfissão(profissao);
        System.out.println("Profissão alterada com sucesso.");
    }

    public void alterarComorbidades(String cpf, List<String> comorbidades) {
        this.pessoas.get(cpf).setComorbidades(comorbidades);
        System.out.println("Comorbidades alterada com sucesso.");
    }

    public void alterarNascimento(String cpf, LocalDateTime dataNascimento) {
        this.pessoas.get(cpf).setDataNascimento(dataNascimento);
        System.out.println("Data de Nascimento alterada com sucesso.");
    }

    public String exibirPessoa(String cpf) {
        if (!this.pessoas.containsKey(cpf)) {
            return "Pessoa não encontrada.";
        } else {
            return this.pessoas.get(cpf).toString();
        }
    }

    public String listarPessoas() {
        String retorno = "";
        for (Pessoa pessoa : this.pessoas.values()) {
            retorno += String.format("%s -*- %s -*- %s -*- %s\n", pessoa.getNome(), pessoa.getCPF(), pessoa.getNumeroSUS(), pessoa.getEstado());
        }
        return retorno;
    }

    public void vacinar(String cpf) {
        if (!this.pessoas.containsKey(cpf)) {
            System.out.println("Pessoa não encontrada.");
        } else {
            Pessoa pessoa = pessoas.get(cpf);
            pessoa.getEstado().vacinar(pessoa);
            System.out.println(pessoa.getEstado().toString());
        }
    }

    public String exibirEstado(String cpf) {
        if (!this.pessoas.containsKey(cpf)) {
            return "Pessoa não encontrada.";
        } else {
            return String.format("Status de vacinação: %s" , pessoas.get(cpf).getEstado().toString());
        }

    }
}

