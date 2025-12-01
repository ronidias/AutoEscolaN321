package br.com.senai.autoescolan321.application.core.domain.model;

import br.com.senai.autoescolan321.application.core.domain.enums.Especialidade;
import br.com.senai.autoescolan321.application.core.domain.vo.Endereco;

public class Instrutor {
    private Long id;
    private Boolean ativo;
    private String nome;
    private String email;
    private String telefone;
    private String cnh;
    private Especialidade especialidade;
    private Endereco endereco;

    public Instrutor() {}

    public Instrutor(
            Long id,
            Boolean ativo,
            String nome,
            String email,
            String telefone,
            String cnh,
            Especialidade especialidade,
            Endereco endereco) {
        this.id = id;
        this.ativo = ativo;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cnh = cnh;
        this.especialidade = especialidade;
        this.endereco = endereco;
    }

    /*public void atualizarInformacoes(DadosAtualizacaoInstrutor dados) {
        if(dados.nome() != null) {
            this.nome = dados.nome();
        }
        if(dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
        if(dados.especialidade() != null) {
            this.especialidade = dados.especialidade();
        }
        if(dados.endereco() != null) {
            endereco.atualizarInformacoes(dados.endereco());
        }
    }*/

    /*public void excluir() {
        this.ativo = false;
    }*/

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

    public String getCnh() {
        return cnh;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}