package br.com.senai.autoescolan321.adapters.out.repository.persistence;

import br.com.senai.autoescolan321.application.core.domain.model.Aluno;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    Page<Aluno> findAllByAtivoTrue(Pageable paginacao);

    @Query("""
            SELECT e.ativo
            FROM Aluno e
            WHERE
            e.id = :id
    """)
    Boolean findAlunoAtivo(Long id);
}