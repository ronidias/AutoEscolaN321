package br.com.senai.autoescolan321.adapters.out.repository;

import br.com.senai.autoescolan321.adapters.out.repository.entity.InstrucaoEntity;
import br.com.senai.autoescolan321.adapters.out.repository.mapper.InstrucaoEntityMapper;
import br.com.senai.autoescolan321.adapters.out.repository.persistence.InstrucaoJpaRepository;
import br.com.senai.autoescolan321.application.core.domain.model.Instrucao;
import br.com.senai.autoescolan321.application.ports.out.InstrucaoRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class InstrucaoRepositoryImpl implements InstrucaoRepository {
    private final InstrucaoEntityMapper instrucaoEntityMapper;
    private final InstrucaoJpaRepository instrucaoJpaRepository;

    public InstrucaoRepositoryImpl(
            InstrucaoEntityMapper instrucaoEntityMapper,
            InstrucaoJpaRepository instrucaoJpaRepository) {
        this.instrucaoEntityMapper = instrucaoEntityMapper;
        this.instrucaoJpaRepository = instrucaoJpaRepository;
    }

    @Override
    public Instrucao save(Instrucao instrucao) {
        InstrucaoEntity entity = instrucaoEntityMapper.toEntity(instrucao);
        InstrucaoEntity saved = instrucaoJpaRepository.save(entity);
        return instrucaoEntityMapper.toDomain(saved);
    }

    @Override
    public Optional<Instrucao> findById(Long id) {
        return instrucaoJpaRepository.findById(id)
                .map(instrucaoEntityMapper::toDomain);
    }
}