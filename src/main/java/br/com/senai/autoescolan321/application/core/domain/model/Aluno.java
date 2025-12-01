package br.com.senai.autoescolan321.application.core.domain.model;

import br.com.senai.autoescolan321.application.core.domain.vo.Endereco;

public class Aluno {
    private Long id;
    private Boolean ativo;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    private Endereco endereco;

    public Aluno() {}

    public Aluno(
            Long id,
            Boolean ativo,
            String nome,
            String email,
            String telefone,
            String cpf,
            Endereco endereco) {
        this.id = id;
        this.ativo = ativo;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /*public void excluir() {
        this.ativo = false;
    }*/

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}