package br.com.senai.autoescolan321.adapters.out.repository.persistence;

import br.com.senai.autoescolan321.adapters.out.repository.entity.AlunoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoJpaRepository extends JpaRepository<AlunoEntity, Long> {
    Page<AlunoEntity> findAllByAtivoTrue(Pageable paginacao);

    @Query("""
            SELECT e.ativo
            FROM Aluno e
            WHERE
            e.id = :id
    """)
    Boolean findAlunoAtivo(Long id);
}