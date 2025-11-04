package br.com.senai.autoescolan321.model.dto.instrutor;


import br.com.senai.autoescolan321.domain.Instrutor;
import br.com.senai.autoescolan321.enumeration.Especialidade;
import br.com.senai.autoescolan321.model.Endereco;

public record DadosDetalhamentoInstrutor(



        Long id,
        Boolean ativo,
        String nome,
        String email,
        String telefone,
        String cnh,
        Especialidade especialidade,
        Endereco endereco)

{

    public DadosDetalhamentoInstrutor(Instrutor instrutor) {
        this(
                instrutor.getId(),
                instrutor.getAtivo(),
                instrutor.getNome(),
                instrutor.getEmail(),
                instrutor.getTelefone(),
                instrutor.getCnh(),
                instrutor.getEspecialidade(),
                instrutor.getEndereco());
    }
}