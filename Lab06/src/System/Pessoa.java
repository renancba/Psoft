package System;

import Estados.*;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class Pessoa {

    private String nome;

    private String CPF;

    private String endereço;

    private int numeroSUS;

    private String email;

    private String telefone;

    private String profissão;

    private List<String> comorbidades;

    private LocalDateTime dataNascimento;

    private Estado estado;

    private LocalDateTime dataPrimeiraDose;


    public Pessoa(String nome, String CPF, String endereço, int numeroSUS, String email, String telefone, String profissão, List<String> comorbidades, int diaNascimento, int mesNascimento, int anoNascimento) {
        this.nome = nome;
        this.CPF = CPF;
        this.endereço = endereço;
        this.numeroSUS = numeroSUS;
        this.email = email;
        this.telefone = telefone;
        this.profissão = profissão;
        this.comorbidades = comorbidades;
        this.dataNascimento = LocalDateTime.of(anoNascimento, mesNascimento, diaNascimento, 0, 0);;

        this.dataPrimeiraDose = null;
        this.estado = new NaoHabilitada();
    }

    public void updateEstado(Estado estado) {
        estado.updateEstado(this);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public int getNumeroSUS() {
        return numeroSUS;
    }

    public void setNumeroSUS(int numeroSUS) {
        this.numeroSUS = numeroSUS;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getProfissão() {
        return profissão;
    }

    public void setProfissão(String profissão) {
        this.profissão = profissão;
    }

    public List<String> getComorbidades() {
        return comorbidades;
    }

    public void setComorbidades(List<String> comorbidades) {
        this.comorbidades = comorbidades;
    }

    public LocalDateTime getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDateTime dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public LocalDateTime getDataPrimeiraDose() {
        return dataPrimeiraDose;
    }

    public void setDataPrimeiraDose(LocalDateTime dataPrimeiraDose) {
        this.dataPrimeiraDose = dataPrimeiraDose;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s -*- CPF: %s -*- Telefone: %s -*- Endereço: %s -*- Email: %s -*- Número do Cartão do SUS: %s -*- Profissão: %s *-- Comorbidades: %s", this.nome, this.CPF, this.telefone, this.endereço, this.email, this.numeroSUS, this.profissão, this.getComorbidades());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pessoa)) return false;
        Pessoa pessoa = (Pessoa) o;
        return getCPF() == pessoa.getCPF();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCPF());
    }
}
