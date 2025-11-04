package br.com.senai.autoescolan321.domain;

import br.com.senai.autoescolan321.model.dto.aluno.DadosAtualizacaoAluno;
import br.com.senai.autoescolan321.model.Endereco;
import br.com.senai.autoescolan321.model.dto.aluno.DadosCadastroAluno;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name ="Aluno")
@Table(name = "alunos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean ativo;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;

    @Embedded
    private Endereco endereco;

    public Aluno(DadosCadastroAluno dados) {
         this.ativo = true;
         this.nome = dados.nome();
         this.email = dados.email();
         this.telefone = dados.telefone();
         this.cpf = dados.cpf();
         this.endereco = new Endereco(dados.endereco());

    }


    public void atualizarInformacoes(@Valid DadosAtualizacaoAluno dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
        if (dados.endereco() != null) {
            endereco.atualizarInformacoes(dados.endereco());
        }
    }

    public void excluir() {

        this.ativo = false;

    }

}

