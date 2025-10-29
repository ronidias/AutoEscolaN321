package br.com.senai.autoescolan321.model.dto.instrutor;


import br.com.senai.autoescolan321.entity.Instrutor;
import br.com.senai.autoescolan321.enumeration.Especialidade;

public record DadosListagemInstrutor(


        Long id,
        String nome,
        String email,
        String cnh,
        Especialidade especialidade) {

    public DadosListagemInstrutor(Instrutor instrutor) {
        this(instrutor.getId(), instrutor.getNome(), instrutor.getEmail(), instrutor.getCnh(), instrutor.getEspecialidade());
    }
}