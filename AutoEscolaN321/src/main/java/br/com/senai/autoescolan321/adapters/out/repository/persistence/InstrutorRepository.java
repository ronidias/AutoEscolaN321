package br.com.senai.autoescolan321.adapters.out.repository.persistence;

import br.com.senai.autoescolan321.application.core.domain.enums.Especialidade;
import br.com.senai.autoescolan321.application.core.domain.model.Instrutor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface InstrutorRepository extends JpaRepository<Instrutor, Long> {
    Page<Instrutor> findAllByAtivoTrue(Pageable paginacao);

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
    Instrutor escolherInstrutorDisponivel(Especialidade especialidade, LocalDateTime data);

    @Query("""
            SELECT i.ativo
            FROM Instrutor i
            WHERE
            i.id = :id
            """)
    Boolean findInstrutorAtivoById(Long id);
}