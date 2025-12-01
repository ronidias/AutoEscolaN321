package br.com.senai.autoescolan321.adapters.out.repository;

import br.com.senai.autoescolan321.adapters.out.repository.entity.AlunoEntity;
import br.com.senai.autoescolan321.adapters.out.repository.mapper.AlunoEntityMapper;
import br.com.senai.autoescolan321.adapters.out.repository.persistence.AlunoJpaRepository;
import br.com.senai.autoescolan321.application.core.domain.model.Aluno;
import br.com.senai.autoescolan321.application.ports.out.AlunoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AlunoRepositoryImpl implements AlunoRepository {
    private final AlunoEntityMapper alunoEntityMapper;
    private final AlunoJpaRepository alunoJpaRepository;

    public AlunoRepositoryImpl(
            AlunoEntityMapper alunoEntityMapper,
            AlunoJpaRepository alunoJpaRepository) {
        this.alunoEntityMapper = alunoEntityMapper;
        this.alunoJpaRepository = alunoJpaRepository;
    }

    @Override
    public Optional<Aluno> findById(Long id) {
        return alunoJpaRepository.findById(id)
                .map(alunoEntityMapper::toDomain);
    }

    @Override
    public Aluno save(Aluno aluno) {
        AlunoEntity entity = alunoEntityMapper.toEntity(aluno);
        AlunoEntity saved = alunoJpaRepository.save(entity);
        return alunoEntityMapper.toDomain(saved);
    }

    @Override
    public Page<Aluno> findAllByAtivoTrue(Pageable paginacao) {
        return alunoJpaRepository.findAllByAtivoTrue(paginacao)
                .map(alunoEntityMapper::toDomain);
    }
}