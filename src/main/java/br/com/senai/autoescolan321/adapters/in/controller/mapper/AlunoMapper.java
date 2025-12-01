package br.com.senai.autoescolan321.adapters.in.controller.mapper;

import br.com.senai.autoescolan321.adapters.in.controller.request.aluno.DadosAtualizacaoAluno;
import br.com.senai.autoescolan321.adapters.in.controller.request.aluno.DadosCadastroAluno;
import br.com.senai.autoescolan321.adapters.in.controller.response.aluno.DadosDetalhamentoAluno;
import br.com.senai.autoescolan321.adapters.in.controller.response.aluno.DadosListagemAluno;
import br.com.senai.autoescolan321.application.core.domain.model.Aluno;
import org.springframework.stereotype.Component;

@Component
public class AlunoMapper {
    private final EnderecoMapper enderecoMapper;

    public AlunoMapper(EnderecoMapper enderecoMapper) {
        this.enderecoMapper = enderecoMapper;
    }

    public Aluno toEntity(DadosCadastroAluno dados) {
        return new Aluno(
                null,
                true,
                dados.nome(),
                dados.email(),
                dados.telefone(),
                dados.cpf(),
                enderecoMapper.toEntity(dados.endereco())
        );
    }

    public DadosDetalhamentoAluno toDetailsDTO(Aluno aluno) {
        return new DadosDetalhamentoAluno(
                aluno.getId(),
                aluno.getAtivo(),
                aluno.getNome(),
                aluno.getEmail(),
                aluno.getTelefone(),
                aluno.getCpf(),
                enderecoMapper.toDTO(aluno.getEndereco())
        );
    }

    public DadosListagemAluno toListDTO(Aluno aluno) {
        return new DadosListagemAluno(
                aluno.getId(),
                aluno.getNome(),
                aluno.getEmail(),
                aluno.getCpf()
        );
    }

    public void updateEntityFromDTO(DadosAtualizacaoAluno dados, Aluno aluno) {
        if(dados.nome() != null) {
            aluno.setNome(dados.nome());
        }
        if(dados.telefone() != null) {
            aluno.setTelefone(dados.telefone());
        }
        if(dados.endereco() != null) {
            enderecoMapper.toEntity(dados.endereco());
        }
    }
}