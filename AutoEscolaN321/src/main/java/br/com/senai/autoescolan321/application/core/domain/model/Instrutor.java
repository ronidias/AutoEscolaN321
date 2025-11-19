package br.com.senai.autoescolan321.application.core.domain.model;

import br.com.senai.autoescolan321.application.core.domain.enums.Especialidade;
import br.com.senai.autoescolan321.application.core.domain.vo.Endereco;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Instrutor")
@Table(name = "instrutores")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Instrutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean ativo;
    private String nome;
    private String email;
    private String telefone;
    private String cnh;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

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