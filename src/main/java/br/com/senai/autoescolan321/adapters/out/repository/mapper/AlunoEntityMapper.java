package br.com.senai.autoescolan321.adapters.out.repository.mapper;

import br.com.senai.autoescolan321.adapters.out.repository.entity.AlunoEntity;
import br.com.senai.autoescolan321.application.core.domain.model.Aluno;
import org.springframework.stereotype.Component;

@Component
public class AlunoEntityMapper {
    public Aluno toDomain(AlunoEntity entity) {
        return new Aluno(
                entity.getId(),
                entity.getAtivo(),
                entity.getNome(),
                entity.getEmail(),
                entity.getTelefone(),
                entity.getCpf(),
                entity.getEndereco()
        );
    }

    public AlunoEntity toEntity(Aluno aluno) {
        return new AlunoEntity(
                aluno.getId(),
                aluno.getAtivo(),
                aluno.getNome(),
                aluno.getEmail(),
                aluno.getTelefone(),
                aluno.getCpf(),
                aluno.getEndereco()
        );
    }
}