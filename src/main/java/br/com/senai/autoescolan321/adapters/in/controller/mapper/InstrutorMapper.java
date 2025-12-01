package br.com.senai.autoescolan321.adapters.in.controller.mapper;

import br.com.senai.autoescolan321.adapters.in.controller.request.instrutor.DadosAtualizacaoInstrutor;
import br.com.senai.autoescolan321.adapters.in.controller.request.instrutor.DadosCadastroInstrutor;
import br.com.senai.autoescolan321.adapters.in.controller.response.instrutor.DadosDetalhamentoInstrutor;
import br.com.senai.autoescolan321.adapters.in.controller.response.instrutor.DadosListagemInstrutor;
import br.com.senai.autoescolan321.application.core.domain.model.Instrutor;
import org.springframework.stereotype.Component;

@Component
public class InstrutorMapper {
    private final EnderecoMapper enderecoMapper;

    public InstrutorMapper(EnderecoMapper enderecoMapper) {
        this.enderecoMapper = enderecoMapper;
    }

    public Instrutor toEntity(DadosCadastroInstrutor dados) {
        return new Instrutor(
                null,
                true,
                dados.nome(),
                dados.email(),
                dados.telefone(),
                dados.cnh(),
                dados.especialidade(),
                enderecoMapper.toEntity(dados.endereco())
        );
    }

    public DadosDetalhamentoInstrutor toDetailsDTO(Instrutor instrutor) {
        return new DadosDetalhamentoInstrutor(
                instrutor.getId(),
                instrutor.getAtivo(),
                instrutor.getNome(),
                instrutor.getEmail(),
                instrutor.getTelefone(),
                instrutor.getCnh(),
                instrutor.getEspecialidade(),
                enderecoMapper.toDTO(instrutor.getEndereco())
        );
    }

    public DadosListagemInstrutor toListDTO(Instrutor instrutor) {
        return new DadosListagemInstrutor(
                instrutor.getId(),
                instrutor.getNome(),
                instrutor.getEmail(),
                instrutor.getCnh(),
                instrutor.getEspecialidade()
        );
    }

    public void updateEntityFromDTO(DadosAtualizacaoInstrutor dados, Instrutor instrutor) {
        if(dados.nome() != null) {
            instrutor.setNome(dados.nome());
        }
        if(dados.telefone() != null) {
            instrutor.setTelefone(dados.telefone());
        }
        if(dados.especialidade() != null) {
            instrutor.setEspecialidade(dados.especialidade());
        }
        if(dados.endereco() != null) {
            enderecoMapper.updateVOFromDTO(dados.endereco(), instrutor.getEndereco());
        }
    }
}