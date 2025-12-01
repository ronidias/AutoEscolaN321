package br.com.senai.autoescolan321.adapters.out.repository.mapper;

import br.com.senai.autoescolan321.adapters.out.repository.entity.InstrucaoEntity;
import br.com.senai.autoescolan321.application.core.domain.model.Instrucao;
import org.springframework.stereotype.Component;

@Component
public class InstrucaoEntityMapper {
    private final AlunoEntityMapper alunoEntityMapper;
    private final InstrutorEntityMapper instrutorEntityMapper;

    public InstrucaoEntityMapper(
            AlunoEntityMapper alunoEntityMapper,
            InstrutorEntityMapper instrutorEntityMapper) {
        this.alunoEntityMapper = alunoEntityMapper;
        this.instrutorEntityMapper = instrutorEntityMapper;
    }

    public Instrucao toDomain(InstrucaoEntity entity) {
        return new Instrucao(
                entity.getId(),
                alunoEntityMapper.toDomain(entity.getAluno()),
                instrutorEntityMapper.toDomain(entity.getInstrutor()),
                entity.getData(),
                entity.getCancelada(),
                entity.getMotivo(),
                entity.getDataCancelamento()
        );
    }

    public InstrucaoEntity toEntity(Instrucao instrucao) {
        return new InstrucaoEntity(
                instrucao.getId(),
                alunoEntityMapper.toEntity(instrucao.getAluno()),
                instrutorEntityMapper.toEntity(instrucao.getInstrutor()),
                instrucao.getData(),
                instrucao.getCancelada(),
                instrucao.getMotivo(),
                instrucao.getDataCancelamento()
        );
    }
}