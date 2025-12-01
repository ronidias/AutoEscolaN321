package br.com.senai.autoescolan321.application.ports.out;

import br.com.senai.autoescolan321.application.core.domain.model.Aluno;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface AlunoRepository {
    Optional<Aluno> findById(Long id);
    Aluno save(Aluno aluno);
    Page<Aluno> findAllByAtivoTrue(Pageable paginacao);
}