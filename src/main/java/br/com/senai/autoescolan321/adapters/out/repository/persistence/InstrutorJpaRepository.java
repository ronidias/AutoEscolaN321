package br.com.senai.autoescolan321.adapters.out.repository.persistence;

import br.com.senai.autoescolan321.adapters.out.repository.entity.InstrutorEntity;
import br.com.senai.autoescolan321.application.core.domain.enums.Especialidade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface InstrutorJpaRepository extends JpaRepository<InstrutorEntity, Long> {
    Page<InstrutorEntity> findAllByAtivoTrue(Pageable paginacao);

    @Query("""
            SELECT i FROM Instrutor i
            WHERE
            i.ativo = true
            AND
            i.especialidade = :especialidade
            AND
            i.id NOT IN (
                SELECT a.instrutor.id FROM Instrucao a
                WHERE
                a.data = :data
                AND
                a.cancelada = false
            )
            order by rand()
            limit 1
            """)
    InstrutorEntity escolherInstrutorDisponivel(Especialidade especialidade, LocalDateTime data);

    @Query("""
            SELECT i.ativo
            FROM Instrutor i
            WHERE
            i.id = :id
            """)
    Boolean findInstrutorAtivoById(Long id);
}