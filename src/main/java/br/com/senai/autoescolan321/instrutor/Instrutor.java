package br.com.senai.autoescolan321.instrutor;

import br.com.senai.autoescolan321.endereco.DadosEndereco;
import br.com.senai.autoescolan321.endereco.Endereco;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name ="Instrutor")
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

    public  Instrutor(DadosCadastroInstrutor dados) {
         this.ativo = true;
         this.nome = dados.nome();
         this.email = dados.email();
         this.telefone = dados.telefone();
         this.cnh = dados.cnh();
         this.especialidade = dados.especialidade();
         this.endereco = new Endereco(dados.endereco());

    }


    public void atualizarInformacoes(@Valid DadosAtualizacaoInstrutor dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
        if (dados.especialidade() != null) {
            this.especialidade = dados.especialidade();
        }
        if (dados.endereco() != null) {
            endereco.atualizarInformacoes(dados.endereco());
        }
    }

    public void excluir() {

        this.ativo = false;

    }

}

