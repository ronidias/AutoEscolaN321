package br.com.senai.autoescolan321.instrutor;

import br.com.senai.autoescolan321.endereco.Endereco;
import jakarta.persistence.*;
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
    private String nome;
    private String email;
    private String cnh;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    public  Instrutor(DadosCadastroInstrutor dados) {
         this.nome = dados.nome();
         this.email = dados.email();
         this.cnh = dados.cnh();
         this.especialidade = dados.especialidade();
         this.endereco = new Endereco(dados.endereco());

    }

}
