package br.com.senai.autoescolan321.adapters.out.repository;

import br.com.senai.autoescolan321.adapters.out.repository.entity.InstrutorEntity;
import br.com.senai.autoescolan321.adapters.out.repository.mapper.InstrutorEntityMapper;
import br.com.senai.autoescolan321.adapters.out.repository.persistence.InstrutorJpaRepository;
import br.com.senai.autoescolan321.application.core.domain.enums.Especialidade;
import br.com.senai.autoescolan321.application.core.domain.model.Instrutor;
import br.com.senai.autoescolan321.application.ports.out.InstrutorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class InstrutorRepositoryImpl implements InstrutorRepository {
    private final InstrutorJpaRepository instrutorJpaRepository;
    private final InstrutorEntityMapper instrutorEntityMapper;

    public InstrutorRepositoryImpl(
            InstrutorJpaRepository instrutorJpaRepository,
            InstrutorEntityMapper instrutorEntityMapper) {
        this.instrutorJpaRepository = instrutorJpaRepository;
        this.instrutorEntityMapper = instrutorEntityMapper;
    }

    @Override
    public Instrutor save(Instrutor instrutor) {
        InstrutorEntity entity = instrutorEntityMapper.toEntity(instrutor);
        InstrutorEntity saved = instrutorJpaRepository.save(entity);
        return instrutorEntityMapper.toDomain(saved);
    }

    @Override
    public Page<Instrutor> findAllByAtivoTrue(Pageable paginacao) {
        return instrutorJpaRepository.findAllByAtivoTrue(paginacao)
                .map(instrutorEntityMapper::toDomain);
    }

    @Override
    public Optional<Instrutor> findById(Long id) {
        return instrutorJpaRepository.findById(id)
                .map(instrutorEntityMapper::toDomain);
    }

    @Override
    public Instrutor escolherInstrutorDisponivel(Especialidade especialidade, LocalDateTime data) {
        InstrutorEntity entity = instrutorJpaRepository.escolherInstrutorDisponivel(especialidade, data);
        return entity != null ? instrutorEntityMapper.toDomain(entity) : null;
    }
}